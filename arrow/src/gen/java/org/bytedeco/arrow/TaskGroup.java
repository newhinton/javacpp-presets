// Targeted by JavaCPP version 1.5.5: DO NOT EDIT THIS FILE

package org.bytedeco.arrow;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;

import static org.bytedeco.arrow.global.arrow.*;


/** \brief A group of related tasks
 * 
 *  A TaskGroup executes tasks with the signature {@code Status()}.
 *  Execution can be serial or parallel, depending on the TaskGroup
 *  implementation.  When Finish() returns, it is guaranteed that all
 *  tasks have finished, or at least one has errored.
 * 
 *  Once an error has occurred any tasks that are submitted to the task group
 *  will not run.  The call to Append will simply return without scheduling the
 *  task.
 * 
 *  If the task group is parallel it is possible that multiple tasks could be
 *  running at the same time and one of those tasks fails.  This will put the
 *  task group in a failure state (so additional tasks cannot be run) however
 *  it will not interrupt running tasks.  Finish will not complete
 *  until all running tasks have finished, even if one task fails.
 * 
 *  Once a task group has finished new tasks may not be added to it.  If you need to start
 *  a new batch of work then you should create a new task group. */
@Namespace("arrow::internal") @Properties(inherit = org.bytedeco.arrow.presets.arrow.class)
public class TaskGroup extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TaskGroup(Pointer p) { super(p); }

  /** Add a Status-returning function to execute.  Execution order is
   *  undefined.  The function may be executed immediately or later. */

  /** Wait for execution of all tasks (and subgroups) to be finished,
   *  or for at least one task (or subgroup) to error out.
   *  The returned Status propagates the error status of the first failing
   *  task (or subgroup). */
  public native @ByVal Status Finish();

  /** The current aggregate error Status.  Non-blocking, useful for stopping early. */
  public native @ByVal Status current_status();

  /** Whether some tasks have already failed.  Non-blocking, useful for stopping early. */
  public native @Cast("bool") boolean ok();

  /** How many tasks can typically be executed in parallel.
   *  This is only a hint, useful for testing or debugging. */
  public native int parallelism();

  public static native @SharedPtr TaskGroup MakeSerial();
  public static native @SharedPtr TaskGroup MakeThreaded(Executor arg0);
}