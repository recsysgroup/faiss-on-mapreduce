/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class Cloner {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Cloner(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Cloner obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_Cloner(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public VectorTransform clone_VectorTransform(VectorTransform arg0) {
    long cPtr = swigfaissJNI.Cloner_clone_VectorTransform(swigCPtr, this, VectorTransform.getCPtr(arg0), arg0);
    return (cPtr == 0) ? null : new VectorTransform(cPtr, true);
  }

  public Index clone_Index(Index arg0) {
    long cPtr = swigfaissJNI.Cloner_clone_Index(swigCPtr, this, Index.getCPtr(arg0), arg0);
    return (cPtr == 0) ? null : new Index(cPtr, false);
  }

  public IndexIVF clone_IndexIVF(IndexIVF arg0) {
    long cPtr = swigfaissJNI.Cloner_clone_IndexIVF(swigCPtr, this, IndexIVF.getCPtr(arg0), arg0);
    return (cPtr == 0) ? null : new IndexIVF(cPtr, false);
  }

  public Cloner() {
    this(swigfaissJNI.new_Cloner(), true);
  }

}
