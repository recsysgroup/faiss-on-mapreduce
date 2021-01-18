/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class MultiIndexQuantizer2 extends MultiIndexQuantizer {
  private transient long swigCPtr;

  protected MultiIndexQuantizer2(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.MultiIndexQuantizer2_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(MultiIndexQuantizer2 obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_MultiIndexQuantizer2(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setAssign_indexes(SWIGTYPE_p_std__vectorT_faiss__Index_p_t value) {
    swigfaissJNI.MultiIndexQuantizer2_assign_indexes_set(swigCPtr, this, SWIGTYPE_p_std__vectorT_faiss__Index_p_t.getCPtr(value));
  }

  public SWIGTYPE_p_std__vectorT_faiss__Index_p_t getAssign_indexes() {
    long cPtr = swigfaissJNI.MultiIndexQuantizer2_assign_indexes_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_std__vectorT_faiss__Index_p_t(cPtr, false);
  }

  public void setOwn_fields(boolean value) {
    swigfaissJNI.MultiIndexQuantizer2_own_fields_set(swigCPtr, this, value);
  }

  public boolean getOwn_fields() {
    return swigfaissJNI.MultiIndexQuantizer2_own_fields_get(swigCPtr, this);
  }

  public MultiIndexQuantizer2(int d, long M, long nbits, SWIGTYPE_p_p_faiss__Index indexes) {
    this(swigfaissJNI.new_MultiIndexQuantizer2__SWIG_0(d, M, nbits, SWIGTYPE_p_p_faiss__Index.getCPtr(indexes)), true);
  }

  public MultiIndexQuantizer2(int d, long nbits, Index assign_index_0, Index assign_index_1) {
    this(swigfaissJNI.new_MultiIndexQuantizer2__SWIG_1(d, nbits, Index.getCPtr(assign_index_0), assign_index_0, Index.getCPtr(assign_index_1), assign_index_1), true);
  }

  public void train(int n, SWIGTYPE_p_float x) {
    swigfaissJNI.MultiIndexQuantizer2_train(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x));
  }

  public void search(int n, SWIGTYPE_p_float x, int k, SWIGTYPE_p_float distances, SWIGTYPE_p_long labels) {
    swigfaissJNI.MultiIndexQuantizer2_search(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), k, SWIGTYPE_p_float.getCPtr(distances), SWIGTYPE_p_long.getCPtr(labels));
  }

}
