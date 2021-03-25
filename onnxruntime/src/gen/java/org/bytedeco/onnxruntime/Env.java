// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.onnxruntime;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.opencl.*;
import static org.bytedeco.opencl.global.OpenCL.*;
import org.bytedeco.dnnl.*;
import static org.bytedeco.dnnl.global.dnnl.*;

import static org.bytedeco.onnxruntime.global.onnxruntime.*;


@Namespace("Ort") @Properties(inherit = org.bytedeco.onnxruntime.presets.onnxruntime.class)
public class Env extends BaseEnv {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public Env(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public Env(long size) { super((Pointer)null); allocateArray(size); }
    private native void allocateArray(long size);
    @Override public Env position(long position) {
        return (Env)super.position(position);
    }
    @Override public Env getPointer(long i) {
        return new Env((Pointer)this).position(position + i);
    }

  public Env(@Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, @Cast("const char*") BytePointer logid/*=""*/) { super((Pointer)null); allocate(logging_level, logid); }
  private native void allocate(@Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, @Cast("const char*") BytePointer logid/*=""*/);
  public Env() { super((Pointer)null); allocate(); }
  private native void allocate();
  public Env(@Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, String logid/*=""*/) { super((Pointer)null); allocate(logging_level, logid); }
  private native void allocate(@Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, String logid/*=""*/);
  public Env(@Const OrtThreadingOptions tp_options, @Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, @Cast("const char*") BytePointer logid/*=""*/) { super((Pointer)null); allocate(tp_options, logging_level, logid); }
  private native void allocate(@Const OrtThreadingOptions tp_options, @Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, @Cast("const char*") BytePointer logid/*=""*/);
  public Env(@Const OrtThreadingOptions tp_options) { super((Pointer)null); allocate(tp_options); }
  private native void allocate(@Const OrtThreadingOptions tp_options);
  public Env(@Const OrtThreadingOptions tp_options, @Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, String logid/*=""*/) { super((Pointer)null); allocate(tp_options, logging_level, logid); }
  private native void allocate(@Const OrtThreadingOptions tp_options, @Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, String logid/*=""*/);
  public Env(@Cast("OrtLoggingLevel") int logging_level, @Cast("const char*") BytePointer logid, OrtLoggingFunction logging_function, Pointer logger_param) { super((Pointer)null); allocate(logging_level, logid, logging_function, logger_param); }
  private native void allocate(@Cast("OrtLoggingLevel") int logging_level, @Cast("const char*") BytePointer logid, OrtLoggingFunction logging_function, Pointer logger_param);
  public Env(@Cast("OrtLoggingLevel") int logging_level, String logid, OrtLoggingFunction logging_function, Pointer logger_param) { super((Pointer)null); allocate(logging_level, logid, logging_function, logger_param); }
  private native void allocate(@Cast("OrtLoggingLevel") int logging_level, String logid, OrtLoggingFunction logging_function, Pointer logger_param);
  public Env(@Const OrtThreadingOptions tp_options, OrtLoggingFunction logging_function, Pointer logger_param,
        @Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, @Cast("const char*") BytePointer logid/*=""*/) { super((Pointer)null); allocate(tp_options, logging_function, logger_param, logging_level, logid); }
  private native void allocate(@Const OrtThreadingOptions tp_options, OrtLoggingFunction logging_function, Pointer logger_param,
        @Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, @Cast("const char*") BytePointer logid/*=""*/);
  public Env(@Const OrtThreadingOptions tp_options, OrtLoggingFunction logging_function, Pointer logger_param) { super((Pointer)null); allocate(tp_options, logging_function, logger_param); }
  private native void allocate(@Const OrtThreadingOptions tp_options, OrtLoggingFunction logging_function, Pointer logger_param);
  public Env(@Const OrtThreadingOptions tp_options, OrtLoggingFunction logging_function, Pointer logger_param,
        @Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, String logid/*=""*/) { super((Pointer)null); allocate(tp_options, logging_function, logger_param, logging_level, logid); }
  private native void allocate(@Const OrtThreadingOptions tp_options, OrtLoggingFunction logging_function, Pointer logger_param,
        @Cast("OrtLoggingLevel") int logging_level/*=ORT_LOGGING_LEVEL_WARNING*/, String logid/*=""*/);
  public Env(OrtEnv p) { super((Pointer)null); allocate(p); }
  private native void allocate(OrtEnv p);

  public native @ByRef Env EnableTelemetryEvents();
  public native @ByRef Env DisableTelemetryEvents();

  public native @ByRef Env CreateAndRegisterAllocator(@Const OrtMemoryInfo mem_info, @Const OrtArenaCfg arena_cfg);

  
}