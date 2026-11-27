package ca.bc.gov.mal.cirras.policies.persistence.v1.dao;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dto.ClaimSearchDto;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class PojoTest {

	//@Test
//	public void testGenerateEqualsAll() throws Exception {
//		Class<InsuranceClaimDto> aClass = InsuranceClaimDto.class;
//		
//		for(Field field: aClass.getDeclaredFields()) {
//			String fn = field.getName();
//			String compareStr = String.format("result = result&&dtoUtils.equals(\"%s\", %s, other.%s);", fn, fn, fn);
//			System.out.println(compareStr);
//		}
//	}
//	
//	
//	//@Test
//	public void testGenerateGetSet() throws Exception {
//		Class<InsuranceClaimVarietyDto> aClass = InsuranceClaimVarietyDto.class;
//		
//		for(Field field: aClass.getDeclaredFields()) {
//			String fn = field.getName();
//			String capFn = fn.substring(0, 1).toUpperCase() + fn.substring(1);
//			String compareStr = String.format("a.set%s(b.get%s());", capFn, capFn);
//			System.out.println(compareStr);
//		}
//	}
	
	@Test
	public void testGenerateCopyConstructor() throws Exception {
		Class<ClaimSearchDto> aClass = ClaimSearchDto.class;
		
		for(Field field: aClass.getDeclaredFields()) {
			String fn = field.getName();
			String compareStr = String.format("this.%s = other.%s;", fn, fn);
			System.out.println(compareStr);
		}
	}
}
