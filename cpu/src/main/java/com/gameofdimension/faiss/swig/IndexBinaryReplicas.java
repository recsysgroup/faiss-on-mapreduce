/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class IndexBinaryReplicas extends ThreadedIndexBaseBinary {
  private transient long swigCPtr;

  protected IndexBinaryReplicas(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.IndexBinaryReplicas_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IndexBinaryReplicas obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_IndexBinaryReplicas(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public IndexBinaryReplicas(boolean threaded) {
    this(swigfaissJNI.new_IndexBinaryReplicas__SWIG_0(threaded), true);
  }

  public IndexBinaryReplicas() {
    this(swigfaissJNI.new_IndexBinaryReplicas__SWIG_1(), true);
  }

  public IndexBinaryReplicas(int d, boolean threaded) {
    this(swigfaissJNI.new_IndexBinaryReplicas__SWIG_2(d, threaded), true);
  }

  public IndexBinaryReplicas(int d) {
    this(swigfaissJNI.new_IndexBinaryReplicas__SWIG_3(d), true);
  }

  public void add_replica(IndexBinary index) {
    swigfaissJNI.IndexBinaryReplicas_add_replica(swigCPtr, this, IndexBinary.getCPtr(index), index);
  }

  public void remove_replica(IndexBinary index) {
    swigfaissJNI.IndexBinaryReplicas_remove_replica(swigCPtr, this, IndexBinary.getCPtr(index), index);
  }

  public void train(int n, SWIGTYPE_p_unsigned_char x) {
    swigfaissJNI.IndexBinaryReplicas_train(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x));
  }

  public void add(int n, SWIGTYPE_p_unsigned_char x) {
    swigfaissJNI.IndexBinaryReplicas_add(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x));
  }

  public void search(int n, SWIGTYPE_p_unsigned_char x, int k, SWIGTYPE_p_int distances, SWIGTYPE_p_long labels) {
    swigfaissJNI.IndexBinaryReplicas_search(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x), k, SWIGTYPE_p_int.getCPtr(distances), SWIGTYPE_p_long.getCPtr(labels));
  }

  public void reconstruct(int arg0, SWIGTYPE_p_unsigned_char v) {
    swigfaissJNI.IndexBinaryReplicas_reconstruct(swigCPtr, this, arg0, SWIGTYPE_p_unsigned_char.getCPtr(v));
  }

}
