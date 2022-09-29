package com.chicken.project.billTax.model.dto;

public class BillTaxDTO {

    private int taxNo;             // 세금계산서 번호
    private String storeNo;       // 가맹점 사업자등록번호
    private String storeName;      // 가맹점 이름
    private String storeAddress;   // 가맹점 주소
    private String taxDate;        // 세금계산서 발급일자
    private String itemName;       // 품명
    private String itemStandard;   // 품목규격
    private int itemSales;         // 매출가격
    private String storeRep;       // 가맹점주 명
    private String recDate;        // 입고일자
    private int recAmount;         // 수량
    private int recMoney;          // 품목병 입고금액
    private int recTotalMoney;     // 발주서 총 합계금액
    private String recCode;        // 입고코드
    private int recSupply;         // 물품공급가액
    private int recTax;            // 물품 세액

    public BillTaxDTO() {
    }

    public BillTaxDTO(int taxNo, String storeNo, String storeName, String storeAddress, String taxDate, String itemName, String itemStandard, int itemSales, String storeRep, String recDate, int recAmount, int recMoney, int recTotalMoney, String recCode, int recSupply, int recTax) {
        this.taxNo = taxNo;
        this.storeNo = storeNo;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.taxDate = taxDate;
        this.itemName = itemName;
        this.itemStandard = itemStandard;
        this.itemSales = itemSales;
        this.storeRep = storeRep;
        this.recDate = recDate;
        this.recAmount = recAmount;
        this.recMoney = recMoney;
        this.recTotalMoney = recTotalMoney;
        this.recCode = recCode;
        this.recSupply = recSupply;
        this.recTax = recTax;
    }

    public int getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(int taxNo) {
        this.taxNo = taxNo;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(String taxDate) {
        this.taxDate = taxDate;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemStandard() {
        return itemStandard;
    }

    public void setItemStandard(String itemStandard) {
        this.itemStandard = itemStandard;
    }

    public int getItemSales() {
        return itemSales;
    }

    public void setItemSales(int itemSales) {
        this.itemSales = itemSales;
    }

    public String getStoreRep() {
        return storeRep;
    }

    public void setStoreRep(String storeRep) {
        this.storeRep = storeRep;
    }

    public String getRecDate() {
        return recDate;
    }

    public void setRecDate(String recDate) {
        this.recDate = recDate;
    }

    public int getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(int recAmount) {
        this.recAmount = recAmount;
    }

    public int getRecMoney() {
        return recMoney;
    }

    public void setRecMoney(int recMoney) {
        this.recMoney = recMoney;
    }

    public int getRecTotalMoney() {
        return recTotalMoney;
    }

    public void setRecTotalMoney(int recTotalMoney) {
        this.recTotalMoney = recTotalMoney;
    }

    public String getRecCode() {
        return recCode;
    }

    public void setRecCode(String recCode) {
        this.recCode = recCode;
    }

    public int getRecSupply() {
        return recSupply;
    }

    public void setRecSupply(int recSupply) {
        this.recSupply = recSupply;
    }

    public int getRecTax() {
        return recTax;
    }

    public void setRecTax(int recTax) {
        this.recTax = recTax;
    }

    @Override
    public String toString() {
        return "BillTaxDTO{" +
                "taxNo=" + taxNo +
                ", storeNo='" + storeNo + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", taxDate='" + taxDate + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemStandard='" + itemStandard + '\'' +
                ", itemSales=" + itemSales +
                ", storeRep='" + storeRep + '\'' +
                ", recDate='" + recDate + '\'' +
                ", recAmount=" + recAmount +
                ", recMoney=" + recMoney +
                ", recTotalMoney=" + recTotalMoney +
                ", recCode='" + recCode + '\'' +
                ", recSupply=" + recSupply +
                ", recTax=" + recTax +
                '}';
    }
}
