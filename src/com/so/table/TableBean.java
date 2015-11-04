package com.so.table;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.so.table.Values;

@ManagedBean
@ViewScoped
public class TableBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Values> values;

	@PostConstruct
	public void init() {
		values = Arrays.asList(new Values(1, 2), new Values(2, 3));
		doCalc();
	}

	public void onCellEdit() {
		doCalc();
	}

	public void log(String s) {
		System.out.println(s);
	}

	public void doCalc() {
		for (Values v : values) {
			v.doCalc();
			log("doCalc: " + v.getX() + " * " + v.getY() + " = " + v.getCalc());
		}
	}

	public List<Values> getValues() {
		return values;
	}

	public List<Integer> completeX(String query) {
		return IntStream.range(0, 10).boxed().collect(Collectors.toList());
	}

	public List<Integer> completeY(String query) {
		return IntStream.range(0, 10).boxed().collect(Collectors.toList());
	}
}