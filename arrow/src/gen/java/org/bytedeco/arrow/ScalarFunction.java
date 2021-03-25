// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;
  // namespace detail

/** \brief A function that executes elementwise operations on arrays or
 *  scalars, and therefore whose results generally do not depend on the order
 *  of the values in the arguments. Accepts and returns arrays that are all of
 *  the same size. These functions roughly correspond to the functions used in
 *  SQL expressions. */
@Namespace("arrow::compute") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class ScalarFunction extends Function {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ScalarFunction(Pointer p) { super(p); }


  public ScalarFunction(@StdString String name, @Const @ByRef Arity arity, @Const FunctionDoc doc,
                   @Const FunctionOptions default_options/*=nullptr*/) { super((Pointer)null); allocate(name, arity, doc, default_options); }
  private native void allocate(@StdString String name, @Const @ByRef Arity arity, @Const FunctionDoc doc,
                   @Const FunctionOptions default_options/*=nullptr*/);
  public ScalarFunction(@StdString String name, @Const @ByRef Arity arity, @Const FunctionDoc doc) { super((Pointer)null); allocate(name, arity, doc); }
  private native void allocate(@StdString String name, @Const @ByRef Arity arity, @Const FunctionDoc doc);
  public ScalarFunction(@StdString BytePointer name, @Const @ByRef Arity arity, @Const FunctionDoc doc,
                   @Const FunctionOptions default_options/*=nullptr*/) { super((Pointer)null); allocate(name, arity, doc, default_options); }
  private native void allocate(@StdString BytePointer name, @Const @ByRef Arity arity, @Const FunctionDoc doc,
                   @Const FunctionOptions default_options/*=nullptr*/);
  public ScalarFunction(@StdString BytePointer name, @Const @ByRef Arity arity, @Const FunctionDoc doc) { super((Pointer)null); allocate(name, arity, doc); }
  private native void allocate(@StdString BytePointer name, @Const @ByRef Arity arity, @Const FunctionDoc doc);

  /** \brief Add a kernel with given input/output types, no required state
   *  initialization, preallocation for fixed-width types, and default null
   *  handling (intersect validity bitmaps of inputs). */
  public native @ByVal Status AddKernel(@StdVector InputType in_types, @ByVal OutputType out_type,
                     @ByVal @Cast("arrow::compute::ArrayKernelExec*") Pointer exec, @ByVal(nullValue = "arrow::compute::KernelInit(nullptr)") @Cast("arrow::compute::KernelInit*") Pointer init);
  public native @ByVal Status AddKernel(@StdVector InputType in_types, @ByVal OutputType out_type,
                     @ByVal @Cast("arrow::compute::ArrayKernelExec*") Pointer exec);

  /** \brief Add a kernel (function implementation). Returns error if the
   *  kernel's signature does not match the function's arity. */
  public native @ByVal Status AddKernel(@ByVal ScalarKernel kernel);

  public native @ByVal @Cast("arrow::Result<const arrow::compute::Kernel*>*") KernelResult DispatchExact(
        @Const @ByRef ValueDescrVector values);
}