package com.yacht.supermarkt.repository;

import com.yacht.supermarkt.business.discountrules.DiscountRule;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRuleRepository extends CrudRepository<DiscountRule, Long> {
}
