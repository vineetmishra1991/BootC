package net.thoughtforge.service;

import net.thoughtforge.aspect.Profilable;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {

	@Profilable
	public void doSomething() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException interruptedException) {}
	}

	@Profilable
	public void doSomethingFiftyTimes() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException interruptedException) {}
		
		for (int i = 0; i < 50; i++) {
			doSomething();
		}
	}
	
	@Profilable
	public void doSomethingWithSomething() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException interruptedException) {}
		
		getSomething();
	}
	
	@Profilable
	public void doSomethingWithSomethingFiftyTimes() {
		try {
			Thread.sleep(75);
		} catch (InterruptedException interruptedException) {}
		
		for (int i = 0; i < 50; i++) {
			doSomethingWithSomething();
		}
	}
	
	@Profilable
	public Object getSomething() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException interruptedException) {}
		
		return new Object();
	}
}
