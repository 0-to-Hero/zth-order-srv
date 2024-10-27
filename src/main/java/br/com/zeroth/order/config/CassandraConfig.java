package br.com.zeroth.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
@EnableCassandraRepositories(basePackages = "br.com.zeroth.order.repository")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "order_ksp"; // Substitua pelo nome do seu keyspace
    }

    @Override
    protected String getContactPoints() {
        return "localhost";
    }

    @Override
    protected int getPort() {
        return 9042;
    }

    @Bean
    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints(getContactPoints());
        session.setKeyspaceName(getKeyspaceName());
        session.setPort(getPort());
        session.setLocalDatacenter(getLocalDataCenter());
        return session;
    }

    @Bean
    public CassandraAdminTemplate cassandraTemplate() {
        return new CassandraAdminTemplate(cassandraSession().getObject());
    }
}