package com.myfinance.controller;

import com.myfinance.domain.AbstractEntity;

public interface AbstractController<T extends AbstractEntity> extends Dao<T> {
	
}
