// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.cuda.nvml;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.cuda.cudart.*;
import static org.bytedeco.cuda.global.cudart.*;

import static org.bytedeco.cuda.global.nvml.*;


/**
 * Possible values that classify the remap availability for each bank. The max
 * field will contain the number of banks that have maximum remap availability
 * (all reserved rows are available). None means that there are no reserved
 * rows available.
 */
@Properties(inherit = org.bytedeco.cuda.presets.nvml.class)
public class nvmlRowRemapperHistogramValues_t extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public nvmlRowRemapperHistogramValues_t() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public nvmlRowRemapperHistogramValues_t(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public nvmlRowRemapperHistogramValues_t(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public nvmlRowRemapperHistogramValues_t position(long position) {
        return (nvmlRowRemapperHistogramValues_t)super.position(position);
    }
    @Override public nvmlRowRemapperHistogramValues_t getPointer(long i) {
        return new nvmlRowRemapperHistogramValues_t((Pointer)this).position(position + i);
    }

    public native @Cast("unsigned int") int max(); public native nvmlRowRemapperHistogramValues_t max(int setter);
    public native @Cast("unsigned int") int high(); public native nvmlRowRemapperHistogramValues_t high(int setter);
    public native @Cast("unsigned int") int partial(); public native nvmlRowRemapperHistogramValues_t partial(int setter);
    public native @Cast("unsigned int") int low(); public native nvmlRowRemapperHistogramValues_t low(int setter);
    public native @Cast("unsigned int") int none(); public native nvmlRowRemapperHistogramValues_t none(int setter);
}