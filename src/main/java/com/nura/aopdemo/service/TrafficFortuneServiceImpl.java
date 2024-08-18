package com.nura.aopdemo.service;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements ITrafficFortuneService {

	@Override
	public String getFortune(boolean tripwire) {

		if (tripwire) {
			throw new RuntimeException("Major accident Highway closed.");
		}

		return "Expect a Heavy Traffic this morning";
	}

	@Override
	public String getFortune() {

		return getFortune(false);
	}

}
