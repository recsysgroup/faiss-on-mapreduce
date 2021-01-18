/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class IVFSearchParameters {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected IVFSearchParameters(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IVFSearchParameters obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_IVFSearchParameters(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setNprobe(long value) {
    swigfaissJNI.IVFSearchParameters_nprobe_set(swigCPtr, this, value);
  }

  public long getNprobe() {
    return swigfaissJNI.IVFSearchParameters_nprobe_get(swigCPtr, this);
  }

  public void setMax_codes(long value) {
    swigfaissJNI.IVFSearchParameters_max_codes_set(swigCPtr, this, value);
  }

  public long getMax_codes() {
    return swigfaissJNI.IVFSearchParameters_max_codes_get(swigCPtr, this);
  }

  public IVFSearchParameters() {
    this(swigfaissJNI.new_IVFSearchParameters(), true);
  }

}
