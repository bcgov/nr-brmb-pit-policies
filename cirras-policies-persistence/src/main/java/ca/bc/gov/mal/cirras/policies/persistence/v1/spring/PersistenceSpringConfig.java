package ca.bc.gov.mal.cirras.policies.persistence.v1.spring;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.sql.DataSource;

import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerContractYearDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerContractYearOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.GrowerContractYearDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.GrowerContractYearOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimCalculationSubmitDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ClaimSearchDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CodeOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CodeSyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityTypeCodeOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityTypeCodeSyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityTypeVarietyXrefOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CommodityVarietySyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ContactsDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ContactsOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CoveragePerilOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CoveragePerilSyncDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.CropTypeOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.EmailsDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.EmailsOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.GrowerOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.InsuredGrowerContactsDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.InsuredGrowerContactsOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.PolicyDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.PolicyOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ProductDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ProductNolDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.ProductOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.TelecomDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.TelecomOutboxDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.UserDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.VarietyDao;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ClaimCalculationSubmitDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ClaimDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ClaimOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ClaimSearchDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CodeOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CodeSyncDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CommodityTypeCodeOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CommodityTypeCodeSyncDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CommodityTypeVarietyXrefOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CommodityVarietySyncDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ContactsDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ContactsOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CoveragePerilOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CoveragePerilSyncDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.CropTypeOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.EmailsDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.EmailsOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.GrowerDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.GrowerOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.InsuredGrowerContactsDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.InsuredGrowerContactsOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.PolicyDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.PolicyOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ProductDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ProductNolDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.ProductOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.TelecomDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.TelecomOutboxDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.UserDaoImpl;
import ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.VarietyDaoImpl;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.BooleanTypeHandler;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.InstantTypeHandler;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.LocalDateTimeTypeHandler;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.LocalDateTypeHandler;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.LocalTimeTypeHandler;
import ca.bc.gov.nrs.wfone.common.persistence.dao.mybatis.ResetDirtyInterceptor;

@Configuration
@EnableTransactionManagement
public class PersistenceSpringConfig {

	private static final Logger logger = LoggerFactory.getLogger(PersistenceSpringConfig.class);
	
	public PersistenceSpringConfig() {
		logger.debug("<PersistenceSpringConfig");
		
		logger.debug(">PersistenceSpringConfig");
	}

	@Bean
	public PlatformTransactionManager transactionManager(@Qualifier("cirrasDataSource") DataSource cirrasDataSource) {
		return new DataSourceTransactionManager(cirrasDataSource);
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(@Qualifier("cirrasDataSource") DataSource cirrasDataSource) {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(cirrasDataSource);
		
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		
		configuration.setCacheEnabled(true);
		configuration.setLazyLoadingEnabled(true);
		configuration.setAggressiveLazyLoading(false);
		configuration.setLocalCacheScope(LocalCacheScope.SESSION);
		
		TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
		typeHandlerRegistry.register(Boolean.class, JdbcType.VARCHAR, BooleanTypeHandler.class);
		typeHandlerRegistry.register(LocalTime.class, JdbcType.VARCHAR, LocalTimeTypeHandler.class);
		typeHandlerRegistry.register(LocalDate.class, JdbcType.DATE, LocalDateTypeHandler.class);
		typeHandlerRegistry.register(LocalDateTime.class, JdbcType.TIMESTAMP, LocalDateTimeTypeHandler.class);
		typeHandlerRegistry.register(Instant.class, JdbcType.TIMESTAMP, InstantTypeHandler.class);
		
		sessionFactory.setConfiguration(configuration);
		
		sessionFactory.setPlugins(new ResetDirtyInterceptor());
		
		return sessionFactory;
	}

	@Bean
	public static MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
		configurer.setBasePackage("ca.bc.gov.mal.cirras.policies.persistence.v1.dao.mybatis.mapper");
		configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return configurer;
	}

	
	@Bean
	public ClaimSearchDao claimSearchDao() { 
		return new ClaimSearchDaoImpl(); 
	}
	
	@Bean
	public ClaimDao claimDao() { 
		return new ClaimDaoImpl(); 
	}

	@Bean
	public CodeSyncDao codeSyncDao() { 
		return new CodeSyncDaoImpl(); 
	}
	
	@Bean
	public CommodityVarietySyncDao commodityVarietySyncDao() { 
		return new CommodityVarietySyncDaoImpl(); 
	}
	
	@Bean
	public GrowerDao growerDao() { 
		return new GrowerDaoImpl(); 
	}

	@Bean
	public PolicyDao policyDao() { 
		return new PolicyDaoImpl(); 
	}
		
	@Bean
	public ProductNolDao productNolDao() { 
		return new ProductNolDaoImpl(); 
	}
	
	@Bean
	public VarietyDao varietyDao() { 
		return new VarietyDaoImpl(); 
	}

	@Bean
	public ClaimOutboxDao claimOutboxDao() { 
		return new ClaimOutboxDaoImpl(); 
	}
	
	@Bean
	public GrowerOutboxDao growerOutboxDao() { 
		return new GrowerOutboxDaoImpl(); 
	}	
	
	@Bean
	public ClaimCalculationSubmitDao claimCalculationSubmitDao() { 
		return new ClaimCalculationSubmitDaoImpl(); 
	}
	
	@Bean
	public PolicyOutboxDao policyOutboxDao() { 
		return new PolicyOutboxDaoImpl(); 
	}

	@Bean
	public CropTypeOutboxDao cropTypeOutboxDao() { 
		return new CropTypeOutboxDaoImpl(); 
	}
	
	@Bean
	public CoveragePerilOutboxDao coveragePerilOutboxDao() { 
		return new CoveragePerilOutboxDaoImpl(); 
	}
	
	@Bean
	public CoveragePerilSyncDao coveragePerilSyncDao() { 
		return new CoveragePerilSyncDaoImpl(); 
	}
	
	@Bean
	public UserDao userDao() { 
		return new UserDaoImpl(); 
	}

	@Bean
	public CodeOutboxDao codeOutboxDao() { 
		return new CodeOutboxDaoImpl(); 
	}

	@Bean
	public ContactsOutboxDao contactsOutboxDao() { 
		return new ContactsOutboxDaoImpl(); 
	}

	@Bean
	public ContactsDao contactsDao() { 
		return new ContactsDaoImpl(); 
	}
	
	@Bean
	public InsuredGrowerContactsOutboxDao insuredGrowerContactsOutboxDao() { 
		return new InsuredGrowerContactsOutboxDaoImpl(); 
	}

	@Bean
	public InsuredGrowerContactsDao insuredGrowerContactsDao() { 
		return new InsuredGrowerContactsDaoImpl(); 
	}

	@Bean
	public EmailsOutboxDao emailsOutboxDao() { 
		return new EmailsOutboxDaoImpl(); 
	}

	@Bean
	public EmailsDao emailsDao() { 
		return new EmailsDaoImpl(); 
	}

	@Bean
	public TelecomOutboxDao telecomOutboxDao() { 
		return new TelecomOutboxDaoImpl(); 
	}

	@Bean
	public TelecomDao telecomDao() { 
		return new TelecomDaoImpl(); 
	}

	@Bean
	public ProductOutboxDao productOutboxDao() { 
		return new ProductOutboxDaoImpl(); 
	}
	
	@Bean
	public ProductDao productDao() { 
		return new ProductDaoImpl(); 
	}

	@Bean
	public CommodityTypeCodeOutboxDao commodityTypeCodeOutboxDao() { 
		return new CommodityTypeCodeOutboxDaoImpl(); 
	}

	@Bean
	public CommodityTypeCodeSyncDao commodityTypeCodeSyncDao() { 
		return new CommodityTypeCodeSyncDaoImpl(); 
	}
	
	@Bean
	public CommodityTypeVarietyXrefOutboxDao commodityTypeVarietyXrefOutboxDao() { 
		return new CommodityTypeVarietyXrefOutboxDaoImpl();
	}

	@Bean
	public GrowerContractYearDao growerContractYearDao() { 
		return new GrowerContractYearDaoImpl(); 
	}
	
	@Bean
	public GrowerContractYearOutboxDao growerContractYearOutboxDao() { 
		return new GrowerContractYearOutboxDaoImpl(); 
	}	
	
}
