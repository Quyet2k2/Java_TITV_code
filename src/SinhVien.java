public class SinhVien {
  private String maSinhVien;
  private String hoVaTen;
  private int namSinh;
  private double diemTrungBinh;

  public SinhVien() {
  }

  public SinhVien(String maSinhVien, String hoVaTen, int namSinh, double diemTrungBinh) {
    this.maSinhVien = maSinhVien;
    this.hoVaTen = hoVaTen;
    this.namSinh = namSinh;
    this.diemTrungBinh = diemTrungBinh;
  }

  public String getMaSinhVien() {
    return this.maSinhVien;
  }

  public void setMaSinhVien(String maSinhVien) {
    this.maSinhVien = maSinhVien;
  }

  public String getHoVaTen() {
    return this.hoVaTen;
  }

  public void setHoVaTen(String hoVaTen) {
    this.hoVaTen = hoVaTen;
  }

  public int getNamSinh() {
    return this.namSinh;
  }

  public void setNamSinh(int namSinh) {
    this.namSinh = namSinh;
  }

  public double getDiemTrungBinh() {
    return this.diemTrungBinh;
  }

  public void setDiemTrungBinh(double diemTrungBinh) {
    this.diemTrungBinh = diemTrungBinh;
  }

  public SinhVien maSinhVien(String maSinhVien) {
    setMaSinhVien(maSinhVien);
    return this;
  }

  public SinhVien hoVaTen(String hoVaTen) {
    setHoVaTen(hoVaTen);
    return this;
  }

  public SinhVien namSinh(int namSinh) {
    setNamSinh(namSinh);
    return this;
  }

  public SinhVien diemTrungBinh(double diemTrungBinh) {
    setDiemTrungBinh(diemTrungBinh);
    return this;
  }

  @Override
  public String toString() {
    return "{" +
        " maSinhVien='" + getMaSinhVien() + "'" +
        ", hoVaTen='" + getHoVaTen() + "'" +
        ", namSinh='" + getNamSinh() + "'" +
        ", diemTrungBinh='" + getDiemTrungBinh() + "'" +
        "}";
  }

}
