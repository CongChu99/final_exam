package com.example.finalexam.specification;


import com.example.finalexam.entity.Account;
import com.example.finalexam.form.AccountFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.parameters.P;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AccountSpecification {
    public static Specification<Account> buildSpec(AccountFilterForm form) {
        return (form == null) ? null : (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (form.getMinId() != null) {
                Path<Integer> id = root.get("id");
                Predicate predicate = builder.greaterThanOrEqualTo(id, form.getMinId());
                predicates.add(predicate);
            }
            if (form.getMaxId() != null) {
                Path<Integer> id = root.get("id");
                Predicate predicate = builder.lessThanOrEqualTo(id, form.getMaxId());
                predicates.add(predicate);
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
