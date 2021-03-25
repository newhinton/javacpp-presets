// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


@Namespace("arrow::ipc::feather") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class WriteProperties extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public WriteProperties() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public WriteProperties(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public WriteProperties(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public WriteProperties position(long position) {
        return (WriteProperties)super.position(position);
    }
    @Override public WriteProperties getPointer(long i) {
        return new WriteProperties((Pointer)this).position(position + i);
    }

  public static native @ByVal WriteProperties Defaults();

  
  ///
  public static native @ByVal WriteProperties DefaultsV1();

  /** Feather file version number
   * 
   *  version 2: "Feather V1" Apache Arrow <= 0.16.0
   *  version 3: "Feather V2" Apache Arrow > 0.16.0 */
  public native int version(); public native WriteProperties version(int setter);

  // Parameters for Feather V2 only

  /** Number of rows per intra-file chunk. Use smaller chunksize when you need
   *  faster random row access */
  public native @Cast("int64_t") long chunksize(); public native WriteProperties chunksize(long setter);

  /** Compression type to use. Only UNCOMPRESSED, LZ4_FRAME, and ZSTD are
   *  supported. The default compression returned by Defaults() is LZ4 if the
   *  project is built with support for it, otherwise
   *  UNCOMPRESSED. UNCOMPRESSED is set as the object default here so that if
   *  WriteProperties::Defaults() is not used, the default constructor for
   *  WriteProperties will work regardless of the options used to build the C++
   *  project. */
  public native Compression.type compression(); public native WriteProperties compression(Compression.type setter);

  /** Compressor-specific compression level */
  public native int compression_level(); public native WriteProperties compression_level(int setter);
}