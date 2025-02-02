// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


// List encodings: using the terminology from Impala to define different styles
// of representing logical lists (a.k.a. ARRAY types) in Parquet schemas. Since
// the converted type named in the Parquet metadata is ConvertedType::LIST we
// use that terminology here. It also helps distinguish from the *_ARRAY
// primitive types.
//
// One-level encoding: Only allows required lists with required cells
//   repeated value_type name
//
// Two-level encoding: Enables optional lists with only required cells
//   <required/optional> group list
//     repeated value_type item
//
// Three-level encoding: Enables optional lists with optional cells
//   <required/optional> group bag
//     repeated group list
//       <required/optional> value_type item
//
// 2- and 1-level encoding are respectively equivalent to 3-level encoding with
// the non-repeated nodes set to required.
//
// The "official" encoding recommended in the Parquet spec is the 3-level, and
// we use that as the default when creating list types. For semantic completeness
// we allow the other two. Since all types of encodings will occur "in the
// wild" we need to be able to interpret the associated definition levels in
// the context of the actual encoding used in the file.
//
// NB: Some Parquet writers may not set ConvertedType::LIST on the repeated
// SchemaElement, which could make things challenging if we are trying to infer
// that a sequence of nodes semantically represents an array according to one
// of these encodings (versus a struct containing an array). We should refuse
// the temptation to guess, as they say.
@Namespace("parquet::schema") @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class ListEncoding extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public ListEncoding() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public ListEncoding(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ListEncoding(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public ListEncoding position(long position) {
        return (ListEncoding)super.position(position);
    }
    @Override public ListEncoding getPointer(long i) {
        return new ListEncoding((Pointer)this).offsetAddress(i);
    }

  public enum type { ONE_LEVEL(0), TWO_LEVEL(1), THREE_LEVEL(2);

      public final int value;
      private type(int v) { this.value = v; }
      private type(type e) { this.value = e.value; }
      public type intern() { for (type e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }
}
