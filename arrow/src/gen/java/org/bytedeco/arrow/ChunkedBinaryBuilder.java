// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


// ----------------------------------------------------------------------
// Chunked builders: build a sequence of BinaryArray or StringArray that are
// limited to a particular size (to the upper limit of 2GB)

@Namespace("arrow::internal") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class ChunkedBinaryBuilder extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ChunkedBinaryBuilder(Pointer p) { super(p); }

  public ChunkedBinaryBuilder(int max_chunk_value_length,
                                  MemoryPool pool/*=arrow::default_memory_pool()*/) { super((Pointer)null); allocate(max_chunk_value_length, pool); }
  private native void allocate(int max_chunk_value_length,
                                  MemoryPool pool/*=arrow::default_memory_pool()*/);
  public ChunkedBinaryBuilder(int max_chunk_value_length) { super((Pointer)null); allocate(max_chunk_value_length); }
  private native void allocate(int max_chunk_value_length);

  public ChunkedBinaryBuilder(int max_chunk_value_length, int max_chunk_length,
                         MemoryPool pool/*=arrow::default_memory_pool()*/) { super((Pointer)null); allocate(max_chunk_value_length, max_chunk_length, pool); }
  private native void allocate(int max_chunk_value_length, int max_chunk_length,
                         MemoryPool pool/*=arrow::default_memory_pool()*/);
  public ChunkedBinaryBuilder(int max_chunk_value_length, int max_chunk_length) { super((Pointer)null); allocate(max_chunk_value_length, max_chunk_length); }
  private native void allocate(int max_chunk_value_length, int max_chunk_length);

  public native @ByVal Status Append(@Cast("const uint8_t*") BytePointer value, int length);
  public native @ByVal Status Append(@Cast("const uint8_t*") ByteBuffer value, int length);
  public native @ByVal Status Append(@Cast("const uint8_t*") byte[] value, int length);

  public native @ByVal Status AppendNull();

  public native @ByVal Status Reserve(@Cast("int64_t") long values);

  public native @ByVal Status Finish(ArrayVector out);
}