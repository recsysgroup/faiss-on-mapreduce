/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class VisitedTable {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected VisitedTable(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(VisitedTable obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_VisitedTable(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setVisited(ByteVector value) {
    swigfaissJNI.VisitedTable_visited_set(swigCPtr, this, ByteVector.getCPtr(value), value);
  }

  public ByteVector getVisited() {
    long cPtr = swigfaissJNI.VisitedTable_visited_get(swigCPtr, this);
    return (cPtr == 0) ? null : new ByteVector(cPtr, false);
  }

  public void setVisno(int value) {
    swigfaissJNI.VisitedTable_visno_set(swigCPtr, this, value);
  }

  public int getVisno() {
    return swigfaissJNI.VisitedTable_visno_get(swigCPtr, this);
  }

  public VisitedTable(int size) {
    this(swigfaissJNI.new_VisitedTable(size), true);
  }

  public void set(int no) {
    swigfaissJNI.VisitedTable_set(swigCPtr, this, no);
  }

  public boolean get(int no) {
    return swigfaissJNI.VisitedTable_get(swigCPtr, this, no);
  }

  public void advance() {
    swigfaissJNI.VisitedTable_advance(swigCPtr, this);
  }

}
