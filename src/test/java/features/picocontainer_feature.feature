Feature: picocontainer test
	
	@pico
	Scenario Outline: Testing picocontainer
		Given test_step_1 "<keyword>"
		When test_step_2
		Then test_step_3
		
		Examples:
		|keyword|
		|test_1 |
		|test_2 |