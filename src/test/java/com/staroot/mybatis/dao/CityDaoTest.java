/**
 *    Copyright 2015-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.staroot.mybatis.dao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.staroot.mybatis.domain.City;
import com.staroot.mybatis.mapper.CityAnnotationMapper;
import com.staroot.mybatis.mapper.CityMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
//@Import(CityDao.class)
public class CityDaoTest {

  @Autowired
  private CityDao cityDao;

  @Autowired
  private CityMapper cityMapper;
  
  @Autowired
  private CityAnnotationMapper cityAnnotationMapper;
  
  @Test
  public void selectCityByIdTest() {
    City city = cityDao.selectCityById(1);
    assertThat(city.getName()).isEqualTo("San Francisco");
    assertThat(city.getState()).isEqualTo("CA");
    assertThat(city.getCountry()).isEqualTo("US");
  }
  @Test
  public void selectCityByIdMapperTest() {
    City city = cityMapper.selectCityById(1);
    System.out.println("********** cityMapper From : "+ city.getName());
    assertThat(city.getName()).isEqualTo("San Francisco");
    assertThat(city.getState()).isEqualTo("CA");
    assertThat(city.getCountry()).isEqualTo("US");
  }
  @Test
  public void selectCityById_with_out_mapperTest() {
    City city = cityDao.selectCityById_with_out_mapper(1);
    assertThat(city.getName()).isEqualTo("San Francisco");
    assertThat(city.getState()).isEqualTo("CA");
    assertThat(city.getCountry()).isEqualTo("US");
  }
  @Test
  public void selectCityByIdAnnotationMapperTest() {
    City city = cityAnnotationMapper.selectCityByIdAnnotation(1);
    System.out.println("********** cityMapper From : "+ city.getName());
    assertThat(city.getName()).isEqualTo("San Francisco");
    assertThat(city.getState()).isEqualTo("CA");
    assertThat(city.getCountry()).isEqualTo("US");
  }
    

}
