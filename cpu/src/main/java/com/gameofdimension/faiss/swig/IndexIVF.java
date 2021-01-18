/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gameofdimension.faiss.swig;

public class IndexIVF extends Index {
  private transient long swigCPtr;

  protected IndexIVF(long cPtr, boolean cMemoryOwn) {
    super(swigfaissJNI.IndexIVF_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IndexIVF obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        swigfaissJNI.delete_IndexIVF(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setInvlists(InvertedLists value) {
    swigfaissJNI.IndexIVF_invlists_set(swigCPtr, this, InvertedLists.getCPtr(value), value);
  }

  public InvertedLists getInvlists() {
    long cPtr = swigfaissJNI.IndexIVF_invlists_get(swigCPtr, this);
    return (cPtr == 0) ? null : new InvertedLists(cPtr, false);
  }

  public void setOwn_invlists(boolean value) {
    swigfaissJNI.IndexIVF_own_invlists_set(swigCPtr, this, value);
  }

  public boolean getOwn_invlists() {
    return swigfaissJNI.IndexIVF_own_invlists_get(swigCPtr, this);
  }

  public void setCode_size(long value) {
    swigfaissJNI.IndexIVF_code_size_set(swigCPtr, this, value);
  }

  public long getCode_size() {
    return swigfaissJNI.IndexIVF_code_size_get(swigCPtr, this);
  }

  public void setNprobe(long value) {
    swigfaissJNI.IndexIVF_nprobe_set(swigCPtr, this, value);
  }

  public long getNprobe() {
    return swigfaissJNI.IndexIVF_nprobe_get(swigCPtr, this);
  }

  public void setMax_codes(long value) {
    swigfaissJNI.IndexIVF_max_codes_set(swigCPtr, this, value);
  }

  public long getMax_codes() {
    return swigfaissJNI.IndexIVF_max_codes_get(swigCPtr, this);
  }

  public void setParallel_mode(int value) {
    swigfaissJNI.IndexIVF_parallel_mode_set(swigCPtr, this, value);
  }

  public int getParallel_mode() {
    return swigfaissJNI.IndexIVF_parallel_mode_get(swigCPtr, this);
  }

  public void setMaintain_direct_map(boolean value) {
    swigfaissJNI.IndexIVF_maintain_direct_map_set(swigCPtr, this, value);
  }

  public boolean getMaintain_direct_map() {
    return swigfaissJNI.IndexIVF_maintain_direct_map_get(swigCPtr, this);
  }

  public void setDirect_map(LongVector value) {
    swigfaissJNI.IndexIVF_direct_map_set(swigCPtr, this, LongVector.getCPtr(value), value);
  }

  public LongVector getDirect_map() {
    long cPtr = swigfaissJNI.IndexIVF_direct_map_get(swigCPtr, this);
    return (cPtr == 0) ? null : new LongVector(cPtr, false);
  }

  public void reset() {
    swigfaissJNI.IndexIVF_reset(swigCPtr, this);
  }

  public void train(int n, SWIGTYPE_p_float x) {
    swigfaissJNI.IndexIVF_train(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x));
  }

  public void add(int n, SWIGTYPE_p_float x) {
    swigfaissJNI.IndexIVF_add(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x));
  }

  public void add_with_ids(int n, SWIGTYPE_p_float x, SWIGTYPE_p_long xids) {
    swigfaissJNI.IndexIVF_add_with_ids(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), SWIGTYPE_p_long.getCPtr(xids));
  }

  public void encode_vectors(int n, SWIGTYPE_p_float x, SWIGTYPE_p_long list_nos, SWIGTYPE_p_unsigned_char codes, boolean include_listno) {
    swigfaissJNI.IndexIVF_encode_vectors__SWIG_0(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), SWIGTYPE_p_long.getCPtr(list_nos), SWIGTYPE_p_unsigned_char.getCPtr(codes), include_listno);
  }

  public void encode_vectors(int n, SWIGTYPE_p_float x, SWIGTYPE_p_long list_nos, SWIGTYPE_p_unsigned_char codes) {
    swigfaissJNI.IndexIVF_encode_vectors__SWIG_1(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), SWIGTYPE_p_long.getCPtr(list_nos), SWIGTYPE_p_unsigned_char.getCPtr(codes));
  }

  public void train_residual(int n, SWIGTYPE_p_float x) {
    swigfaissJNI.IndexIVF_train_residual(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x));
  }

  public void search_preassigned(int n, SWIGTYPE_p_float x, int k, SWIGTYPE_p_long assign, SWIGTYPE_p_float centroid_dis, SWIGTYPE_p_float distances, SWIGTYPE_p_long labels, boolean store_pairs, IVFSearchParameters params) {
    swigfaissJNI.IndexIVF_search_preassigned__SWIG_0(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), k, SWIGTYPE_p_long.getCPtr(assign), SWIGTYPE_p_float.getCPtr(centroid_dis), SWIGTYPE_p_float.getCPtr(distances), SWIGTYPE_p_long.getCPtr(labels), store_pairs, IVFSearchParameters.getCPtr(params), params);
  }

  public void search_preassigned(int n, SWIGTYPE_p_float x, int k, SWIGTYPE_p_long assign, SWIGTYPE_p_float centroid_dis, SWIGTYPE_p_float distances, SWIGTYPE_p_long labels, boolean store_pairs) {
    swigfaissJNI.IndexIVF_search_preassigned__SWIG_1(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), k, SWIGTYPE_p_long.getCPtr(assign), SWIGTYPE_p_float.getCPtr(centroid_dis), SWIGTYPE_p_float.getCPtr(distances), SWIGTYPE_p_long.getCPtr(labels), store_pairs);
  }

  public void search(int n, SWIGTYPE_p_float x, int k, SWIGTYPE_p_float distances, SWIGTYPE_p_long labels) {
    swigfaissJNI.IndexIVF_search(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), k, SWIGTYPE_p_float.getCPtr(distances), SWIGTYPE_p_long.getCPtr(labels));
  }

  public void range_search(int n, SWIGTYPE_p_float x, float radius, RangeSearchResult result) {
    swigfaissJNI.IndexIVF_range_search(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), radius, RangeSearchResult.getCPtr(result), result);
  }

  public void range_search_preassigned(int nx, SWIGTYPE_p_float x, float radius, SWIGTYPE_p_long keys, SWIGTYPE_p_float coarse_dis, RangeSearchResult result) {
    swigfaissJNI.IndexIVF_range_search_preassigned(swigCPtr, this, nx, SWIGTYPE_p_float.getCPtr(x), radius, SWIGTYPE_p_long.getCPtr(keys), SWIGTYPE_p_float.getCPtr(coarse_dis), RangeSearchResult.getCPtr(result), result);
  }

  public SWIGTYPE_p_faiss__InvertedListScanner get_InvertedListScanner(boolean store_pairs) {
    long cPtr = swigfaissJNI.IndexIVF_get_InvertedListScanner__SWIG_0(swigCPtr, this, store_pairs);
    return (cPtr == 0) ? null : new SWIGTYPE_p_faiss__InvertedListScanner(cPtr, false);
  }

  public SWIGTYPE_p_faiss__InvertedListScanner get_InvertedListScanner() {
    long cPtr = swigfaissJNI.IndexIVF_get_InvertedListScanner__SWIG_1(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_faiss__InvertedListScanner(cPtr, false);
  }

  public void reconstruct(int key, SWIGTYPE_p_float recons) {
    swigfaissJNI.IndexIVF_reconstruct(swigCPtr, this, key, SWIGTYPE_p_float.getCPtr(recons));
  }

  public void reconstruct_n(int i0, int ni, SWIGTYPE_p_float recons) {
    swigfaissJNI.IndexIVF_reconstruct_n(swigCPtr, this, i0, ni, SWIGTYPE_p_float.getCPtr(recons));
  }

  public void search_and_reconstruct(int n, SWIGTYPE_p_float x, int k, SWIGTYPE_p_float distances, SWIGTYPE_p_long labels, SWIGTYPE_p_float recons) {
    swigfaissJNI.IndexIVF_search_and_reconstruct(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), k, SWIGTYPE_p_float.getCPtr(distances), SWIGTYPE_p_long.getCPtr(labels), SWIGTYPE_p_float.getCPtr(recons));
  }

  public void reconstruct_from_offset(int list_no, int offset, SWIGTYPE_p_float recons) {
    swigfaissJNI.IndexIVF_reconstruct_from_offset(swigCPtr, this, list_no, offset, SWIGTYPE_p_float.getCPtr(recons));
  }

  public long remove_ids(IDSelector sel) {
    return swigfaissJNI.IndexIVF_remove_ids(swigCPtr, this, IDSelector.getCPtr(sel), sel);
  }

  public void check_compatible_for_merge(IndexIVF other) {
    swigfaissJNI.IndexIVF_check_compatible_for_merge(swigCPtr, this, IndexIVF.getCPtr(other), other);
  }

  public void merge_from(IndexIVF other, int add_id) {
    swigfaissJNI.IndexIVF_merge_from(swigCPtr, this, IndexIVF.getCPtr(other), other, add_id);
  }

  public void copy_subset_to(IndexIVF other, int subset_type, int a1, int a2) {
    swigfaissJNI.IndexIVF_copy_subset_to(swigCPtr, this, IndexIVF.getCPtr(other), other, subset_type, a1, a2);
  }

  public long get_list_size(long list_no) {
    return swigfaissJNI.IndexIVF_get_list_size(swigCPtr, this, list_no);
  }

  public void make_direct_map(boolean new_maintain_direct_map) {
    swigfaissJNI.IndexIVF_make_direct_map__SWIG_0(swigCPtr, this, new_maintain_direct_map);
  }

  public void make_direct_map() {
    swigfaissJNI.IndexIVF_make_direct_map__SWIG_1(swigCPtr, this);
  }

  public void replace_invlists(InvertedLists il, boolean own) {
    swigfaissJNI.IndexIVF_replace_invlists__SWIG_0(swigCPtr, this, InvertedLists.getCPtr(il), il, own);
  }

  public void replace_invlists(InvertedLists il) {
    swigfaissJNI.IndexIVF_replace_invlists__SWIG_1(swigCPtr, this, InvertedLists.getCPtr(il), il);
  }

  public long sa_code_size() {
    return swigfaissJNI.IndexIVF_sa_code_size(swigCPtr, this);
  }

  public void sa_encode(int n, SWIGTYPE_p_float x, SWIGTYPE_p_unsigned_char bytes) {
    swigfaissJNI.IndexIVF_sa_encode(swigCPtr, this, n, SWIGTYPE_p_float.getCPtr(x), SWIGTYPE_p_unsigned_char.getCPtr(bytes));
  }

}
