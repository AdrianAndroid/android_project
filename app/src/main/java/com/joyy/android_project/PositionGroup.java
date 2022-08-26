package com.joyy.android_project;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PositionGroup {
    private static final String SPLIT = "\t";
    private List<Line> lines = new ArrayList<>();

    private Rect rect = new Rect(900, 900);

    private boolean debug = false;

    public PositionGroup(Rect rect) {
        this.rect = rect;
    }

    public void printLines() {
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            System.out.println("i=" + i + " , " + line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public void readFile(String absolutFileName) throws IOException {
        File file = new File(absolutFileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(readLine(line));
        }
    }

    // 一	[31,61,0,35,62,0,39,62,0,44,61,0,49,61,0,53,60,0,56,61,0,61,60,0,64,60,0,66,60,0,69,59,0,69,59,0]	(0,0)	Couch_Big5_65
    public Line readLine(String line) {
        Line l = new Line(this);
        if (line == null) {
            return l;
        }
        String[] split = line.split(SPLIT);
        if (split.length > 3) {
            l.parse(split);
        } else {
            throw new IllegalArgumentException("数据不符合格式 line -> " + line);
        }
        if (debug) System.out.println(l);
        return l;
    }

    public static class Line {
        private PositionGroup parent;
        private String word = ""; // 一
        private String positionString = ""; // [31,61,0,35,62,0,39,62,0,44,61,0,49,61,0,53,60,0,56,61,0,61,60,0,64,60,0,66,60,0,69,59,0,69,59,0]
        private List<Position> positions = new ArrayList<>();
        private Position orgPosition = new Position(); // (0, 0)
        private String charset = "Couch_Big5_65";

        private float xmax = Integer.MIN_VALUE;
        private float xmin = Integer.MAX_VALUE;
        private float scaleX = 0;
        private float ymax = Integer.MIN_VALUE;
        private float ymin = Integer.MAX_VALUE;
        private float scaleY = 0;
        private int scale = 1;

        public float getXmin() {
            return xmin;
        }

        public float getYmin() {
            return ymin;
        }

        public Line(PositionGroup parent) {
            this.parent = parent;
        }

        public List<Position> getPositions() {
            return positions;
        }

        public Map<Integer, List<Position>> getSortPoses() {
            Map<Integer, List<Position>> map = new HashMap<>();
            for (Position pos : positions) {
                int layer = pos.layer;
                List<Position> list = map.get(layer);
                if (list == null) {
                    ArrayList<Position> value = new ArrayList<>();
                    value.add(pos);
                    map.put(layer, value);
                } else {
                    list.add(pos);
                }
            }
            return map;
        }

        public void parse(String[] content) {
            if (content == null) return;
            if (content.length > 0) {
                word = content[0];
            }
            if (content.length > 1) {
                positionString = content[1];
                positions = readPositions(content[1]);
            }
            if (content.length > 2) {
                orgPosition = readOrgPosition(content[2]);
            }
            if (content.length > 3) {
                charset = content[3];
            }
        }

        public Position readOrgPosition(String orgPositionContent) {
            // (0,0)
            return new Position(0, 0);
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        public List<Position> readPositions(String positionContent) {
            // [31,61,0,35,62,0,39,62,0,44,61,0,49,61,0,53,60,0,56,61,0,61,60,0,64,60,0,66,60,0,69,59,0,69,59,0]
            // 143.0
            ArrayList<Position> posArray = new ArrayList<>();
            if (positionContent == null) {
                return posArray;
            }
            String substring = positionContent.substring(1, positionContent.length() - 1);
            String[] split = substring.split(",");
            if (split.length % 3 != 0) {
                throw new IllegalArgumentException("这些坐标点数据有问题啊 -> " + Arrays.toString(split));
            }
            for (int i = 0; i < split.length; i += 3) {
                float saveX = Float.parseFloat(split[i]);
                float saveY = Float.parseFloat(split[i + 1]);
                int layer = Math.round(Float.parseFloat(split[i + 2]));

                xmax = Math.max(xmax, saveX);
                xmin = Math.min(xmin, saveX);
                ymax = Math.max(ymax, saveY);
                ymin = Math.min(ymin, saveY);

                Rect rect = parent.rect;
                scaleX = (xmax - xmin) / rect.width;
                scaleY = (ymax - ymin) / rect.height;
                scale = Math.round(Math.max(scaleX, scaleY));
                if (scale == 0) {
                    scale = 1;
                }

                Position e = new Position(saveX, saveY, layer);
                e.setLine(this);
                posArray.add(e);
            }

            posArray.forEach(position -> position.scale(scale));

            return posArray;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "word='" + word + '\'' +
                    ", positions=" + positions +
                    ", orgPosition=" + orgPosition +
                    ", charset='" + charset + '\'' +
                    '}';
        }
    }

    public static class Position {
        private Line line;
        int x;
        int y;
        int layer;

        float saveX;
        float saveY;

        public Line getLine() {
            return line;
        }

        public void setLine(Line line) {
            this.line = line;
        }

        public Position() {
            this.x = -1;
            this.y = -1;
            this.layer = -1;
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position(float saveX, float saveY, int layer) {
            this.saveX = saveX;
            this.saveY = saveY;
            this.layer = layer;
        }

        public void scale(int scale) {
            this.x = (int) ((saveX - line.getXmin()) / scale);
            this.y = (int) ((saveY - line.getYmin()) / scale);
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    ", layer=" + layer +
                    '}';
        }
    }

    public static class Rect {
        int width = 255;
        int height = 255;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
