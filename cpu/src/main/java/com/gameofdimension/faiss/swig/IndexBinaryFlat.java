/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class IndexBinaryFlat extends IndexBinary {
  private transient long swigCPtr;

  protected IndexBinaryFlat(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.IndexBinaryFlat_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IndexBinaryFlat obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_IndexBinaryFlat(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setXb(ByteVector value) {
    swigfaissJNI.IndexBinaryFlat_xb_set(swigCPtr, this, ByteVector.getCPtr(value), value);
  }

  public ByteVector getXb() {
    long cPtr = swigfaissJNI.IndexBinaryFlat_xb_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ByteVector(cPtr, false);
  }

  public void setUse_heap(boolean value) {
    swigfaissJNI.IndexBinaryFlat_use_heap_set(swigCPtr, this, value);
  }

  public boolean getUse_heap() {
    return swigfaissJNI.IndexBinaryFlat_use_heap_get(swigCPtr, this);
  }

  public void setQuery_batch_size(long value) {
    swigfaissJNI.IndexBinaryFlat_query_batch_size_set(swigCPtr, this, value);
  }

  public long getQuery_batch_size() {
    return swigfaissJNI.IndexBinaryFlat_query_batch_size_get(swigCPtr, this);
  }

  public IndexBinaryFlat(int d) {
    this(swigfaissJNI.new_IndexBinaryFlat__SWIG_0(d), true);
  }

  public void add(int n, SWIGTYPE_p_unsigned_char x) {
    swigfaissJNI.IndexBinaryFlat_add(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x));
  }

  public void reset() {
    swigfaissJNI.IndexBinaryFlat_reset(swigCPtr, this);
  }

  public void search(int n, SWIGTYPE_p_unsigned_char x, int k, SWIGTYPE_p_int distances, SWIGTYPE_p_long labels) {
    swigfaissJNI.IndexBinaryFlat_search(swigCPtr, this, n, SWIGTYPE_p_unsigned_char.getCPtr(x), k, SWIGTYPE_p_int.getCPtr(distances), SWIGTYPE_p_long.getCPtr(labels));
  }

  public void reconstruct(int key, SWIGTYPE_p_unsigned_char recons) {
    swigfaissJNI.IndexBinaryFlat_reconstruct(swigCPtr, this, key, SWIGTYPE_p_unsigned_char.getCPtr(recons));
  }

  public long remove_ids(IDSelector sel) {
    return swigfaissJNI.IndexBinaryFlat_remove_ids(swigCPtr, this, IDSelector.getCPtr(sel), sel);
  }

  public IndexBinaryFlat() {
    this(swigfaissJNI.new_IndexBinaryFlat__SWIG_1(), true);
  }

}
