package com.drivehealth.test.utils.db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;

import org.apache.commons.lang3.StringUtils;

public class Statement implements Serializable {

    private static final long serialVersionUID = -5613883418056781601L;

    private String queryString;

    private List<String> params;

    public Statement(String queryString) {
        this.queryString = queryString;
        this.params = new ArrayList<>();
    }

    public Statement(String queryString, List<String> params) {
        this(queryString);
        this.params = params;
    }

    public String generate(List<String> params) throws Exception {

        if (StringUtils.isBlank(queryString)) {
            return QueryConstants.BLANK_STRING;
        }

        if (params == null) {
            throw new Exception("Statement parameter are not available.");
        }

        if (params.isEmpty()) {

            if (queryString.indexOf(QueryConstants.PARAM_STRING) >= 0) {
                return queryString;
            } else {
                throw new Exception("Some of the query parameters are not replaced.");
            }
        }

        String statement = queryString;

        Iterator<String> paramIt = params.iterator();

        if (paramIt != null) {
            while (paramIt.hasNext()) {
                String param = paramIt.next();
                statement = statement.replaceFirst(QueryConstants.PARAM_STRING, Matcher.quoteReplacement(param));
            }

            if (paramIt.hasNext() || statement.indexOf(QueryConstants.PARAM_STRING) >= 0) {
                throw new Exception("Parameter count mismatch - query expects more/less parameters than param list size: " + params.size());
            }
        }

        return statement;
    }

    public String generate() throws Exception {
        return generate(this.params);
    }

    public String getQueryString() {
        return queryString;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryString);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Statement other = (Statement) obj;
        return Objects.equals(queryString, other.queryString);
    }

    @Override
    public String toString() {
        return "Statement [queryString=" + queryString + ", params=" + params + "]";
    }
}
