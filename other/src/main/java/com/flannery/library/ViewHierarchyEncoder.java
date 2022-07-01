package com.flannery.library;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ViewHierarchyEncoder {
    // Prefixes for simple primitives. These match the JNI definitions.
    private static final byte SIG_BOOLEAN = 'Z';
    private static final byte SIG_BYTE = 'B';
    private static final byte SIG_SHORT = 'S';
    private static final byte SIG_INT = 'I';
    private static final byte SIG_LONG = 'J';
    private static final byte SIG_FLOAT = 'F';
    private static final byte SIG_DOUBLE = 'D';

    // Prefixes for some commonly used objects
    private static final byte SIG_STRING = 'R';

    private static final byte SIG_MAP = 'M'; // a map with an short key
    private static final short SIG_END_MAP = 0;

    private final DataOutputStream mStream;

    private final Map<String, Short> mPropertyNames = new HashMap<String, Short>(200);
    private short mPropertyId = 1;
    private final Charset mCharset = StandardCharsets.UTF_8;

    private boolean mUserPropertiesEnabled = true;

    public ViewHierarchyEncoder(ByteArrayOutputStream stream) {
        mStream = new DataOutputStream(stream);
    }

    public void setUserPropertiesEnabled(boolean enabled) {
        mUserPropertiesEnabled = enabled;
    }

    public void beginObject(Object o) {
        startPropertyMap();
        addProperty("meta:__name__", o.getClass().getName());
        addProperty("meta:__hash__", o.hashCode());
    }

    public void endObject() {
        endPropertyMap();
    }

    public void endStream() {
        // write out the string table
        startPropertyMap();
        addProperty("__name__", "propertyIndex");
        for (Map.Entry<String, Short> entry : mPropertyNames.entrySet()) {
            writeShort(entry.getValue());
            writeString(entry.getKey());
        }
        endPropertyMap();
    }

    @UnsupportedAppUsage
    public void addProperty(String name, boolean v) {
        writeShort(createPropertyIndex(name));
        writeBoolean(v);
    }

    public void addProperty(String name, short s) {
        writeShort(createPropertyIndex(name));
        writeShort(s);
    }

    @UnsupportedAppUsage
    public void addProperty(String name, int v) {
        writeShort(createPropertyIndex(name));
        writeInt(v);
    }

    @UnsupportedAppUsage
    public void addProperty(String name, float v) {
        writeShort(createPropertyIndex(name));
        writeFloat(v);
    }

    @UnsupportedAppUsage
    public void addProperty(String name, String s) {
        writeShort(createPropertyIndex(name));
        writeString(s);
    }

    /**
     * Encodes a user defined property if they are allowed to be encoded
     *
     * @see #setUserPropertiesEnabled(boolean)
     */
    public void addUserProperty(String name, String s) {
        if (mUserPropertiesEnabled) {
            addProperty(name, s);
        }
    }

    /**
     * Writes the given name as the property name, and leaves it to the callee
     * to fill in value for this property.
     */
    public void addPropertyKey(String name) {
        writeShort(createPropertyIndex(name));
    }

    private short createPropertyIndex(String name) {
        Short index = mPropertyNames.get(name);
        if (index == null) {
            index = mPropertyId++;
            mPropertyNames.put(name, index);
        }

        return index;
    }

    private void startPropertyMap() {
        try {
            mStream.write(SIG_MAP);
        } catch (IOException e) {
            // does not happen since the stream simply wraps a ByteArrayOutputStream
        }
    }

    private void endPropertyMap() {
        writeShort(SIG_END_MAP);
    }

    private void writeBoolean(boolean v) {
        try {
            mStream.write(SIG_BOOLEAN);
            mStream.write(v ? 1 : 0);
        } catch (IOException e) {
            // does not happen since the stream simply wraps a ByteArrayOutputStream
        }
    }

    private void writeShort(short s) {
        try {
            mStream.write(SIG_SHORT);
            mStream.writeShort(s);
        } catch (IOException e) {
            // does not happen since the stream simply wraps a ByteArrayOutputStream
        }
    }

    private void writeInt(int i) {
        try {
            mStream.write(SIG_INT);
            mStream.writeInt(i);
        } catch (IOException e) {
            // does not happen since the stream simply wraps a ByteArrayOutputStream
        }
    }

    private void writeFloat(float v) {
        try {
            mStream.write(SIG_FLOAT);
            mStream.writeFloat(v);
        } catch (IOException e) {
            // does not happen since the stream simply wraps a ByteArrayOutputStream
        }
    }

    private void writeString(String s) {
        if (s == null) {
            s = "";
        }

        try {
            mStream.write(SIG_STRING);
            byte[] bytes = s.getBytes(mCharset);

            short len = (short) Math.min(bytes.length, Short.MAX_VALUE);
            mStream.writeShort(len);

            mStream.write(bytes, 0, len);
        } catch (IOException e) {
            // does not happen since the stream simply wraps a ByteArrayOutputStream
        }
    }
}
