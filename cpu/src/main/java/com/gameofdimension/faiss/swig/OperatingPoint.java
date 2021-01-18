/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class OperatingPoint {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected OperatingPoint(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(OperatingPoint obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_OperatingPoint(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setPerf(double value) {
    swigfaissJNI.OperatingPoint_perf_set(swigCPtr, this, value);
  }

  public double getPerf() {
    return swigfaissJNI.OperatingPoint_perf_get(swigCPtr, this);
  }

  public void setT(double value) {
    swigfaissJNI.OperatingPoint_t_set(swigCPtr, this, value);
  }

  public double getT() {
    return swigfaissJNI.OperatingPoint_t_get(swigCPtr, this);
  }

  public void setKey(String value) {
    swigfaissJNI.OperatingPoint_key_set(swigCPtr, this, value);
  }

  public String getKey() {
    return swigfaissJNI.OperatingPoint_key_get(swigCPtr, this);
  }

  public void setCno(int value) {
    swigfaissJNI.OperatingPoint_cno_set(swigCPtr, this, value);
  }

  public int getCno() {
    return swigfaissJNI.OperatingPoint_cno_get(swigCPtr, this);
  }

  public OperatingPoint() {
    this(swigfaissJNI.new_OperatingPoint(), true);
  }

}
