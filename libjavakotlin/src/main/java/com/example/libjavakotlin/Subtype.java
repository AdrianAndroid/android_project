package com.example.libjavakotlin;

import java.util.List;

public class Subtype {
    private List<SubtypeImeDataDTO> subtypeImeData;

    public static class SubtypeImeDataDTO {
        private Boolean asciiCapable;
        private String extraValue;
        private Boolean functionSubtypeSupported;
        private String layoutSet;
        private String localeStr;
        private String nameRes;
        private String latinDictType;
        private Boolean isHardKbdSupprted;

        public Boolean getAsciiCapable() {
            return asciiCapable;
        }

        public void setAsciiCapable(Boolean asciiCapable) {
            this.asciiCapable = asciiCapable;
        }

        public String getExtraValue() {
            return extraValue;
        }

        public void setExtraValue(String extraValue) {
            this.extraValue = extraValue;
        }

        public Boolean getFunctionSubtypeSupported() {
            return functionSubtypeSupported;
        }

        public void setFunctionSubtypeSupported(Boolean functionSubtypeSupported) {
            this.functionSubtypeSupported = functionSubtypeSupported;
        }

        public String getLayoutSet() {
            return layoutSet;
        }

        public void setLayoutSet(String layoutSet) {
            this.layoutSet = layoutSet;
        }

        public String getLocaleStr() {
            return localeStr;
        }

        public void setLocaleStr(String localeStr) {
            this.localeStr = localeStr;
        }

        public String getNameRes() {
            return nameRes;
        }

        public void setNameRes(String nameRes) {
            this.nameRes = nameRes;
        }

        public String getLatinDictType() {
            return latinDictType;
        }

        public void setLatinDictType(String latinDictType) {
            this.latinDictType = latinDictType;
        }

        public Boolean getHardKbdSupprted() {
            return isHardKbdSupprted;
        }

        public void setHardKbdSupprted(Boolean hardKbdSupprted) {
            isHardKbdSupprted = hardKbdSupprted;
        }

        @Override
        public String toString() {
            return "SubtypeImeDataDTO{" +
                    "asciiCapable=" + asciiCapable +
                    ", extraValue='" + extraValue + '\'' +
                    ", functionSubtypeSupported=" + functionSubtypeSupported +
                    ", layoutSet='" + layoutSet + '\'' +
                    ", localeStr='" + localeStr + '\'' +
                    ", nameRes='" + nameRes + '\'' +
                    ", latinDictType='" + latinDictType + '\'' +
                    ", isHardKbdSupprted=" + isHardKbdSupprted +
                    '}';
        }
    }

    public List<SubtypeImeDataDTO> getSubtypeImeData() {
        return subtypeImeData;
    }

    public void setSubtypeImeData(List<SubtypeImeDataDTO> subtypeImeData) {
        this.subtypeImeData = subtypeImeData;
    }

    @Override
    public String toString() {
        return "Subtype{" +
                "subtypeImeData=" + subtypeImeData +
                '}';
    }
}
