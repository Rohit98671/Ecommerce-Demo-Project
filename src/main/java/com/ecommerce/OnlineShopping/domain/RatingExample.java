package com.ecommerce.OnlineShopping.domain;

import java.util.ArrayList;
import java.util.List;

public class RatingExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public RatingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
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

        public Criteria andRatingsidIsNull() {
            addCriterion("RatingsID is null");
            return (Criteria) this;
        }

        public Criteria andRatingsidIsNotNull() {
            addCriterion("RatingsID is not null");
            return (Criteria) this;
        }

        public Criteria andRatingsidEqualTo(Long value) {
            addCriterion("RatingsID =", value, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidNotEqualTo(Long value) {
            addCriterion("RatingsID <>", value, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidGreaterThan(Long value) {
            addCriterion("RatingsID >", value, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidGreaterThanOrEqualTo(Long value) {
            addCriterion("RatingsID >=", value, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidLessThan(Long value) {
            addCriterion("RatingsID <", value, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidLessThanOrEqualTo(Long value) {
            addCriterion("RatingsID <=", value, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidIn(List<Long> values) {
            addCriterion("RatingsID in", values, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidNotIn(List<Long> values) {
            addCriterion("RatingsID not in", values, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidBetween(Long value1, Long value2) {
            addCriterion("RatingsID between", value1, value2, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingsidNotBetween(Long value1, Long value2) {
            addCriterion("RatingsID not between", value1, value2, "ratingsid");
            return (Criteria) this;
        }

        public Criteria andRatingpointIsNull() {
            addCriterion("ratingPoint is null");
            return (Criteria) this;
        }

        public Criteria andRatingpointIsNotNull() {
            addCriterion("ratingPoint is not null");
            return (Criteria) this;
        }

        public Criteria andRatingpointEqualTo(Integer value) {
            addCriterion("ratingPoint =", value, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointNotEqualTo(Integer value) {
            addCriterion("ratingPoint <>", value, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointGreaterThan(Integer value) {
            addCriterion("ratingPoint >", value, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointGreaterThanOrEqualTo(Integer value) {
            addCriterion("ratingPoint >=", value, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointLessThan(Integer value) {
            addCriterion("ratingPoint <", value, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointLessThanOrEqualTo(Integer value) {
            addCriterion("ratingPoint <=", value, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointIn(List<Integer> values) {
            addCriterion("ratingPoint in", values, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointNotIn(List<Integer> values) {
            addCriterion("ratingPoint not in", values, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointBetween(Integer value1, Integer value2) {
            addCriterion("ratingPoint between", value1, value2, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andRatingpointNotBetween(Integer value1, Integer value2) {
            addCriterion("ratingPoint not between", value1, value2, "ratingpoint");
            return (Criteria) this;
        }

        public Criteria andProdidIsNull() {
            addCriterion("prodID is null");
            return (Criteria) this;
        }

        public Criteria andProdidIsNotNull() {
            addCriterion("prodID is not null");
            return (Criteria) this;
        }

        public Criteria andProdidEqualTo(Long value) {
            addCriterion("prodID =", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotEqualTo(Long value) {
            addCriterion("prodID <>", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidGreaterThan(Long value) {
            addCriterion("prodID >", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidGreaterThanOrEqualTo(Long value) {
            addCriterion("prodID >=", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidLessThan(Long value) {
            addCriterion("prodID <", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidLessThanOrEqualTo(Long value) {
            addCriterion("prodID <=", value, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidIn(List<Long> values) {
            addCriterion("prodID in", values, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotIn(List<Long> values) {
            addCriterion("prodID not in", values, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidBetween(Long value1, Long value2) {
            addCriterion("prodID between", value1, value2, "prodid");
            return (Criteria) this;
        }

        public Criteria andProdidNotBetween(Long value1, Long value2) {
            addCriterion("prodID not between", value1, value2, "prodid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table rating
     *
     * @mbg.generated do_not_delete_during_merge Mon May 25 10:16:09 NPT 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table rating
     *
     * @mbg.generated Mon May 25 10:16:09 NPT 2020
     */
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