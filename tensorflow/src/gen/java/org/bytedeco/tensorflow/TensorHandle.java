// Targeted by JavaCPP version 1.5.1-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.tensorflow;

import org.bytedeco.tensorflow.Allocator;
import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.tensorflow.global.tensorflow.*;


// Associates a Tensor and a Device, used in the eager runtime. Internal version
// of the TFE_TensorHandle struct and the python EagerTensor class
// (unrelated to python TensorHandle).
@Namespace("tensorflow") @NoOffset @Properties(inherit = org.bytedeco.tensorflow.presets.tensorflow.class)
public class TensorHandle extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TensorHandle(Pointer p) { super(p); }

  public TensorHandle(@Const @ByRef Tensor t, Device d, Device op_device,
                 EagerContext ctx) { super((Pointer)null); allocate(t, d, op_device, ctx); }
  private native void allocate(@Const @ByRef Tensor t, Device d, Device op_device,
                 EagerContext ctx);
  public TensorHandle(@Cast("tensorflow::uint64") long node_id, Device d, Device op_device,
                 Device resource_device, @Cast("tensorflow::DataType") int dtype, EagerContext ctx) { super((Pointer)null); allocate(node_id, d, op_device, resource_device, dtype, ctx); }
  private native void allocate(@Cast("tensorflow::uint64") long node_id, Device d, Device op_device,
                 Device resource_device, @Cast("tensorflow::DataType") int dtype, EagerContext ctx);

  // Remote tensor handle constructor.
  public TensorHandle(@Cast("tensorflow::int64") long op_id, int output_num, @Cast("tensorflow::uint64") long remote_shape_node_id,
                 @Cast("tensorflow::DataType") int dtype, @ByVal Fn call_on_destroy, Device d,
                 Device op_device, Device resource_device, EagerContext ctx) { super((Pointer)null); allocate(op_id, output_num, remote_shape_node_id, dtype, call_on_destroy, d, op_device, resource_device, ctx); }
  private native void allocate(@Cast("tensorflow::int64") long op_id, int output_num, @Cast("tensorflow::uint64") long remote_shape_node_id,
                 @Cast("tensorflow::DataType") int dtype, @ByVal Fn call_on_destroy, Device d,
                 Device op_device, Device resource_device, EagerContext ctx);

  // Symbolic tensor constructor.
  public TensorHandle(@ByVal OutputGraphNode symbolic_tensor, @Cast("tensorflow::DataType") int dtype) { super((Pointer)null); allocate(symbolic_tensor, dtype); }
  private native void allocate(@ByVal OutputGraphNode symbolic_tensor, @Cast("tensorflow::DataType") int dtype);

  public native @ByVal Status Tensor(@Cast("const tensorflow::Tensor**") PointerPointer t);
  public native @ByVal Status Tensor(@Const @ByPtrPtr Tensor t);

  public native @ByVal Status TensorValue(TensorValue t);

  public native Device device();
  public native Device op_device();
  public native Device resource_device();

  public native @ByVal Status TensorAndDevice(@Cast("const tensorflow::Tensor**") PointerPointer tensor,
                           @Cast("tensorflow::Device**") PointerPointer device,
                           @Cast("tensorflow::Device**") PointerPointer op_device);
  public native @ByVal Status TensorAndDevice(@Const @ByPtrPtr Tensor tensor,
                           @ByPtrPtr Device device,
                           @ByPtrPtr Device op_device);

  public native @ByVal Status Shape(TensorShape shape);

  public native @ByVal Status NumDims(IntPointer num_dims);
  public native @ByVal Status NumDims(IntBuffer num_dims);
  public native @ByVal Status NumDims(int... num_dims);
  public native @ByVal Status Dim(int dim_index, @Cast("tensorflow::int64*") LongPointer dim);
  public native @ByVal Status Dim(int dim_index, @Cast("tensorflow::int64*") LongBuffer dim);
  public native @ByVal Status Dim(int dim_index, @Cast("tensorflow::int64*") long... dim);
  public native @ByVal Status NumElements(@Cast("tensorflow::int64*") LongPointer num_elements);
  public native @ByVal Status NumElements(@Cast("tensorflow::int64*") LongBuffer num_elements);
  public native @ByVal Status NumElements(@Cast("tensorflow::int64*") long... num_elements);

  // Return the op_id and output num if the handle refers to a remote tensor.
  public native @ByVal Status RemoteAddress(@Cast("tensorflow::int64*") LongPointer op_id, IntPointer output_num);
  public native @ByVal Status RemoteAddress(@Cast("tensorflow::int64*") LongBuffer op_id, IntBuffer output_num);
  public native @ByVal Status RemoteAddress(@Cast("tensorflow::int64*") long[] op_id, int... output_num);

  // Note that this can be called at most once, and only on non-ready handles,
  // and makes them ready.
  public native void SetTensor(@Const @ByRef Tensor tensor);

  public native @ByVal Status CopyToDevice(EagerContext ctx, Device dstd,
                        @Cast("tensorflow::TensorHandle**") PointerPointer output);
  public native @ByVal Status CopyToDevice(EagerContext ctx, Device dstd,
                        @ByPtrPtr TensorHandle output);

  // Warning: can return nullptr for CPU tensors.
  public native EagerContext Context();

  // dtype for the handle. It must be the same as t.dtype() once the handle is
  // ready.
  @MemberGetter public native @Cast("const tensorflow::DataType") int dtype();

  public native void SetRemoteShape(@MoveUniquePtr TensorShape remote_shape);

  public native @Cast("bool") boolean OnHostCPU();

  public native @Cast("bool") boolean IsRemote();

  public native OutputGraphNode getSymbolicTensor();

  public native @StdString BytePointer DebugString();

  // If this TensorHandle is 1) a local tensor, and 2) a resource variable,
  // return data type and shape of the resource variable.
  public native @ByVal Status GetResourceVariableDtypeAndShape(
        DataTypeTensorShapePair result);
}