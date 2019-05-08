package com.gangbin.store.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Float value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Float value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Float value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Float value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Float value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Float> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Float> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Float value1, Float value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Float value1, Float value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPublishingDateIsNull() {
            addCriterion("publishing_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishingDateIsNotNull() {
            addCriterion("publishing_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishingDateEqualTo(Date value) {
            addCriterionForJDBCDate("publishing_date =", value, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("publishing_date <>", value, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateGreaterThan(Date value) {
            addCriterionForJDBCDate("publishing_date >", value, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publishing_date >=", value, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateLessThan(Date value) {
            addCriterionForJDBCDate("publishing_date <", value, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("publishing_date <=", value, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateIn(List<Date> values) {
            addCriterionForJDBCDate("publishing_date in", values, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("publishing_date not in", values, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publishing_date between", value1, value2, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andPublishingDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("publishing_date not between", value1, value2, "publishingDate");
            return (Criteria) this;
        }

        public Criteria andSalesAmountIsNull() {
            addCriterion("sales_amount is null");
            return (Criteria) this;
        }

        public Criteria andSalesAmountIsNotNull() {
            addCriterion("sales_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSalesAmountEqualTo(Integer value) {
            addCriterion("sales_amount =", value, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountNotEqualTo(Integer value) {
            addCriterion("sales_amount <>", value, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountGreaterThan(Integer value) {
            addCriterion("sales_amount >", value, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sales_amount >=", value, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountLessThan(Integer value) {
            addCriterion("sales_amount <", value, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountLessThanOrEqualTo(Integer value) {
            addCriterion("sales_amount <=", value, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountIn(List<Integer> values) {
            addCriterion("sales_amount in", values, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountNotIn(List<Integer> values) {
            addCriterion("sales_amount not in", values, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountBetween(Integer value1, Integer value2) {
            addCriterion("sales_amount between", value1, value2, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andSalesAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("sales_amount not between", value1, value2, "salesAmount");
            return (Criteria) this;
        }

        public Criteria andStoreNumberIsNull() {
            addCriterion("store_number is null");
            return (Criteria) this;
        }

        public Criteria andStoreNumberIsNotNull() {
            addCriterion("store_number is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNumberEqualTo(Integer value) {
            addCriterion("store_number =", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberNotEqualTo(Integer value) {
            addCriterion("store_number <>", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberGreaterThan(Integer value) {
            addCriterion("store_number >", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_number >=", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberLessThan(Integer value) {
            addCriterion("store_number <", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberLessThanOrEqualTo(Integer value) {
            addCriterion("store_number <=", value, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberIn(List<Integer> values) {
            addCriterion("store_number in", values, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberNotIn(List<Integer> values) {
            addCriterion("store_number not in", values, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberBetween(Integer value1, Integer value2) {
            addCriterion("store_number between", value1, value2, "storeNumber");
            return (Criteria) this;
        }

        public Criteria andStoreNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("store_number not between", value1, value2, "storeNumber");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}