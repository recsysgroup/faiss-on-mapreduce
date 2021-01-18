/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class PCAMatrix extends LinearTransform {
  private transient long swigCPtr;

  protected PCAMatrix(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.PCAMatrix_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PCAMatrix obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_PCAMatrix(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setEigen_power(float value) {
    swigfaissJNI.PCAMatrix_eigen_power_set(swigCPtr, this, value);
  }

  public float getEigen_power() {
    return swigfaissJNI.PCAMatrix_eigen_power_get(swigCPtr, this);
  }

  public void setRandom_rotation(boolean value) {
    swigfaissJNI.PCAMatrix_random_rotation_set(swigCPtr, this, value);
  }

  public boolean getRandom_rotation() {
    return swigfaissJNI.PCAMatrix_random_rotation_get(swigCPtr, this);
  }

  public void setMax_points_per_d(long value) {
    swigfaissJNI.PCAMatrix_max_points_per_d_set(swigCPtr, this, value);
  }

  public long getMax_points_per_d() {
    return swigfaissJNI.PCAMatrix_max_points_per_d_get(swigCPtr, this);
  }

  public void setBalanced_bins(int value) {
    swigfaissJNI.PCAMatrix_balanced_bins_set(swigCPtr, this, value);
  }

  public int getBalanced_bins() {
    return swigfaissJNI.PCAMatrix_balanced_bins_get(swigCPtr, this);
  }

  public void setMean(FloatVector value) {
    swigfaissJNI.PCAMatrix_mean_set(swigCPtr, this, FloatVector.getCPtr(value), value);
  }

  public FloatVector getMean() {
    long cPtr = swigfaissJNI.PCAMatrix_mean_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FloatVector(cPtr, false);
  }

  public void setEigenvalues(FloatVector value) {
    swigfaissJNI.PCAMatrix_eigenvalues_set(swigCPtr, this, FloatVector.getCPtr(value), value);
  }

  public FloatVector getEigenvalues() {
    long cPtr = swigfaissJNI.PCAMatrix_eigenvalues_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FloatVector(cPtr, false);
  }

  public void setPCAMat(FloatVector value) {
    swigfaissJNI.PCAMatrix_PCAMat_set(swigCPtr, this, FloatVector.getCPtr(value), value);
  }

  public FloatVector getPCAMat() {
    long cPtr = swigfaissJNI.PCAMatrix_PCAMat_get(swigCPtr, this);
    return (cPtr == 0) ? null : new FloatVector(cPtr, false);
  }

  public PCAMatrix(int d_in, int d_out, float eigen_power, boolean random_rotation) {
    this(swigfaissJNI.new_PCAMatrix__SWIG_0(d_in, d_out, eigen_power, random_rotation), true);
  }

  public PCAMatrix(int d_in, int d_out, float eigen_power) {
    this(swigfaissJNI.new_PCAMatrix__SWIG_1(d_in, d_out, eigen_power), true);
  }

  public PCAMatrix(int d_in, int d_out) {
    this(swigfaissJNI.new_PCAMatrix__SWIG_2(d_in, d_out), true);
  }

  public PCAMatrix(int d_in) {
    this(swigfaissJNI.new_PCAMatrix__SWIG_3(d_in), true);
  }

  public PCAMatrix() {
    this(swigfaissJNI.new_PCAMatrix__SWIG_4(), true);
  }

  public void train(int n, SWIGTYPE_p_float x) {
    swigfaissJNI.PCAMatrix_train(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x));
  }

  public void copy_from(PCAMatrix other) {
    swigfaissJNI.PCAMatrix_copy_from(swigCPtr, this, PCAMatrix.getCPtr(other), other);
  }

  public void prepare_Ab() {
    swigfaissJNI.PCAMatrix_prepare_Ab(swigCPtr, this);
  }

}
