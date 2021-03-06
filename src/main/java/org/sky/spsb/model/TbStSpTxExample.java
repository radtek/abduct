package org.sky.spsb.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.sky.sys.utils.BeanUtils;
import org.sky.sys.utils.Page;

public class TbStSpTxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TbStSpTxExample() {
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

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    public List<Criteria> integratedQuery(Map queryCondationMap) {
            Criteria criteria = createCriteriaInternal();
    for(Object key : queryCondationMap.keySet()) {
		String field = ((String)key).split("@")[0];
		String opt = ((String)key).split("@")[1];
		if(((String)key).toUpperCase().contains("BETWEEN")){
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,((String)queryCondationMap.get(key)).split(",")[0],((String)queryCondationMap.get(key)).split(",")[1],(String)key);
		}else if(((String)key).toUpperCase().contains("IS NULL")||((String)key).toUpperCase().contains("IS NOT NULL")){
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt);
		}else if(((String)key).toUpperCase().contains("@IN")||((String)key).toUpperCase().contains("@NOT IN")){
         String values = (String)queryCondationMap.get(key);
 		  List val=Arrays.asList(values.split(","));
 		  criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,val,(String)key);
		}else{
         criteria.addCriterion(BeanUtils.camelToUnderline(field)+" "+opt,queryCondationMap.get(key),(String)key);
		}
    }
	 oredCriteria.add(criteria);
    return oredCriteria;

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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWjmcIsNull() {
            addCriterion("WJMC is null");
            return (Criteria) this;
        }

        public Criteria andWjmcIsNotNull() {
            addCriterion("WJMC is not null");
            return (Criteria) this;
        }

        public Criteria andWjmcEqualTo(String value) {
            addCriterion("WJMC =", value, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcNotEqualTo(String value) {
            addCriterion("WJMC <>", value, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcGreaterThan(String value) {
            addCriterion("WJMC >", value, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcGreaterThanOrEqualTo(String value) {
            addCriterion("WJMC >=", value, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcLessThan(String value) {
            addCriterion("WJMC <", value, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcLessThanOrEqualTo(String value) {
            addCriterion("WJMC <=", value, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcLike(String value) {
            addCriterion("WJMC like", value, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcNotLike(String value) {
            addCriterion("WJMC not like", value, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcIn(List<String> values) {
            addCriterion("WJMC in", values, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcNotIn(List<String> values) {
            addCriterion("WJMC not in", values, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcBetween(String value1, String value2) {
            addCriterion("WJMC between", value1, value2, "wjmc");
            return (Criteria) this;
        }

        public Criteria andWjmcNotBetween(String value1, String value2) {
            addCriterion("WJMC not between", value1, value2, "wjmc");
            return (Criteria) this;
        }

        public Criteria andSpbhIsNull() {
            addCriterion("SPBH is null");
            return (Criteria) this;
        }

        public Criteria andSpbhIsNotNull() {
            addCriterion("SPBH is not null");
            return (Criteria) this;
        }

        public Criteria andSpbhEqualTo(String value) {
            addCriterion("SPBH =", value, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhNotEqualTo(String value) {
            addCriterion("SPBH <>", value, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhGreaterThan(String value) {
            addCriterion("SPBH >", value, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhGreaterThanOrEqualTo(String value) {
            addCriterion("SPBH >=", value, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhLessThan(String value) {
            addCriterion("SPBH <", value, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhLessThanOrEqualTo(String value) {
            addCriterion("SPBH <=", value, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhLike(String value) {
            addCriterion("SPBH like", value, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhNotLike(String value) {
            addCriterion("SPBH not like", value, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhIn(List<String> values) {
            addCriterion("SPBH in", values, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhNotIn(List<String> values) {
            addCriterion("SPBH not in", values, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhBetween(String value1, String value2) {
            addCriterion("SPBH between", value1, value2, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpbhNotBetween(String value1, String value2) {
            addCriterion("SPBH not between", value1, value2, "spbh");
            return (Criteria) this;
        }

        public Criteria andSpwjmcIsNull() {
            addCriterion("SPWJMC is null");
            return (Criteria) this;
        }

        public Criteria andSpwjmcIsNotNull() {
            addCriterion("SPWJMC is not null");
            return (Criteria) this;
        }

        public Criteria andSpwjmcEqualTo(String value) {
            addCriterion("SPWJMC =", value, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcNotEqualTo(String value) {
            addCriterion("SPWJMC <>", value, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcGreaterThan(String value) {
            addCriterion("SPWJMC >", value, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcGreaterThanOrEqualTo(String value) {
            addCriterion("SPWJMC >=", value, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcLessThan(String value) {
            addCriterion("SPWJMC <", value, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcLessThanOrEqualTo(String value) {
            addCriterion("SPWJMC <=", value, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcLike(String value) {
            addCriterion("SPWJMC like", value, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcNotLike(String value) {
            addCriterion("SPWJMC not like", value, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcIn(List<String> values) {
            addCriterion("SPWJMC in", values, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcNotIn(List<String> values) {
            addCriterion("SPWJMC not in", values, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcBetween(String value1, String value2) {
            addCriterion("SPWJMC between", value1, value2, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andSpwjmcNotBetween(String value1, String value2) {
            addCriterion("SPWJMC not between", value1, value2, "spwjmc");
            return (Criteria) this;
        }

        public Criteria andXsdIsNull() {
            addCriterion("XSD is null");
            return (Criteria) this;
        }

        public Criteria andXsdIsNotNull() {
            addCriterion("XSD is not null");
            return (Criteria) this;
        }

        public Criteria andXsdEqualTo(BigDecimal value) {
            addCriterion("XSD =", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdNotEqualTo(BigDecimal value) {
            addCriterion("XSD <>", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdGreaterThan(BigDecimal value) {
            addCriterion("XSD >", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XSD >=", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdLessThan(BigDecimal value) {
            addCriterion("XSD <", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XSD <=", value, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdIn(List<BigDecimal> values) {
            addCriterion("XSD in", values, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdNotIn(List<BigDecimal> values) {
            addCriterion("XSD not in", values, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XSD between", value1, value2, "xsd");
            return (Criteria) this;
        }

        public Criteria andXsdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XSD not between", value1, value2, "xsd");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNull() {
            addCriterion("CREATER is null");
            return (Criteria) this;
        }

        public Criteria andCreaterIsNotNull() {
            addCriterion("CREATER is not null");
            return (Criteria) this;
        }

        public Criteria andCreaterEqualTo(String value) {
            addCriterion("CREATER =", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotEqualTo(String value) {
            addCriterion("CREATER <>", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThan(String value) {
            addCriterion("CREATER >", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("CREATER >=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThan(String value) {
            addCriterion("CREATER <", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("CREATER <=", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterLike(String value) {
            addCriterion("CREATER like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotLike(String value) {
            addCriterion("CREATER not like", value, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterIn(List<String> values) {
            addCriterion("CREATER in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotIn(List<String> values) {
            addCriterion("CREATER not in", values, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterBetween(String value1, String value2) {
            addCriterion("CREATER between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("CREATER not between", value1, value2, "creater");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andZtIsNull() {
            addCriterion("ZT is null");
            return (Criteria) this;
        }

        public Criteria andZtIsNotNull() {
            addCriterion("ZT is not null");
            return (Criteria) this;
        }

        public Criteria andZtEqualTo(String value) {
            addCriterion("ZT =", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotEqualTo(String value) {
            addCriterion("ZT <>", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThan(String value) {
            addCriterion("ZT >", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtGreaterThanOrEqualTo(String value) {
            addCriterion("ZT >=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThan(String value) {
            addCriterion("ZT <", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLessThanOrEqualTo(String value) {
            addCriterion("ZT <=", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtLike(String value) {
            addCriterion("ZT like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotLike(String value) {
            addCriterion("ZT not like", value, "zt");
            return (Criteria) this;
        }

        public Criteria andZtIn(List<String> values) {
            addCriterion("ZT in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotIn(List<String> values) {
            addCriterion("ZT not in", values, "zt");
            return (Criteria) this;
        }

        public Criteria andZtBetween(String value1, String value2) {
            addCriterion("ZT between", value1, value2, "zt");
            return (Criteria) this;
        }

        public Criteria andZtNotBetween(String value1, String value2) {
            addCriterion("ZT not between", value1, value2, "zt");
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