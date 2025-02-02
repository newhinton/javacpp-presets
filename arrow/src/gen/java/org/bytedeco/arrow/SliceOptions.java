// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import org.bytedeco.arrow.Function;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::compute") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class SliceOptions extends FunctionOptions {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public SliceOptions(Pointer p) { super(p); }

  public SliceOptions(@Cast("int64_t") long start, @Cast("int64_t") long stop/*=std::numeric_limits<int64_t>::max()*/,
                          @Cast("int64_t") long step/*=1*/) { super((Pointer)null); allocate(start, stop, step); }
  private native void allocate(@Cast("int64_t") long start, @Cast("int64_t") long stop/*=std::numeric_limits<int64_t>::max()*/,
                          @Cast("int64_t") long step/*=1*/);
  public SliceOptions(@Cast("int64_t") long start) { super((Pointer)null); allocate(start); }
  private native void allocate(@Cast("int64_t") long start);
  public SliceOptions() { super((Pointer)null); allocate(); }
  private native void allocate();
  @MemberGetter public static native byte kTypeName(int i);
  @MemberGetter public static native String kTypeName();
  public native @Cast("int64_t") long start(); public native SliceOptions start(long setter);
  public native @Cast("int64_t") long stop(); public native SliceOptions stop(long setter);
  public native @Cast("int64_t") long step(); public native SliceOptions step(long setter);
}
