// Targeted by JavaCPP version 1.5.6: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// Internal structures used by the status C API. These are likely to change
// and should not be depended on.

@Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TF_Status extends org.bytedeco.tensorflow.AbstractTF_Status {
    static { Loader.load(); }
    /** Default native constructor. */
    public TF_Status() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TF_Status(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TF_Status(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public TF_Status position(long position) {
        return (TF_Status)super.position(position);
    }
    @Override public TF_Status getPointer(long i) {
        return new TF_Status((Pointer)this).offsetAddress(i);
    }

  public native @ByRef Status status(); public native TF_Status status(Status setter);
}
