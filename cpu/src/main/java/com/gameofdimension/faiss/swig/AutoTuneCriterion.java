/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class AutoTuneCriterion {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected AutoTuneCriterion(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AutoTuneCriterion obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_AutoTuneCriterion(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setNq(int value) {
    swigfaissJNI.AutoTuneCriterion_nq_set(swigCPtr, this, value);
  }

  public int getNq() {
    return swigfaissJNI.AutoTuneCriterion_nq_get(swigCPtr, this);
  }

  public void setNnn(int value) {
    swigfaissJNI.AutoTuneCriterion_nnn_set(swigCPtr, this, value);
  }

  public int getNnn() {
    return swigfaissJNI.AutoTuneCriterion_nnn_get(swigCPtr, this);
  }

  public void setGt_nnn(int value) {
    swigfaissJNI.AutoTuneCriterion_gt_nnn_set(swigCPtr, this, value);
  }

  public int getGt_nnn() {
    return swigfaissJNI.AutoTuneCriterion_gt_nnn_get(swigCPtr, this);
  }

  public void setGt_D(FloatVector value) {
    swigfaissJNI.AutoTuneCriterion_gt_D_set(swigCPtr, this, FloatVector.getCPtr(value), value);
  }

  public FloatVector getGt_D() {
    long cPtr = swigfaissJNI.AutoTuneCriterion_gt_D_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FloatVector(cPtr, false);
  }

  public void setGt_I(LongVector value) {
    swigfaissJNI.AutoTuneCriterion_gt_I_set(swigCPtr, this, LongVector.getCPtr(value), value);
  }

  public LongVector getGt_I() {
    long cPtr = swigfaissJNI.AutoTuneCriterion_gt_I_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LongVector(cPtr, false);
  }

  public void set_groundtruth(int gt_nnn, SWIGTYPE_p_float gt_D_in, SWIGTYPE_p_long gt_I_in) {
    swigfaissJNI.AutoTuneCriterion_set_groundtruth(swigCPtr, this, gt_nnn, SWIGTYPE_p_float.getCPtr(gt_D_in), SWIGTYPE_p_long.getCPtr(gt_I_in));
  }

  public double evaluate(SWIGTYPE_p_float D, SWIGTYPE_p_long I) {
    return swigfaissJNI.AutoTuneCriterion_evaluate(swigCPtr, this, SWIGTYPE_p_float.getCPtr(D), SWIGTYPE_p_long.getCPtr(I));
  }

}
