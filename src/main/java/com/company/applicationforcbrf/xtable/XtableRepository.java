package com.company.applicationforcbrf.xtable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XtableRepository extends JpaRepository<Xtable, String> {

}
