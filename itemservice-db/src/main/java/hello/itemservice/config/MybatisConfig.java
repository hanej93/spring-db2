package hello.itemservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.itemservice.repository.ItemRepository;
import hello.itemservice.repository.mybatis.ItemMapper;
import hello.itemservice.repository.mybatis.MybatisItemRepository;
import hello.itemservice.service.ItemService;
import hello.itemservice.service.ItemServiceV1;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MybatisConfig {

	private final ItemMapper itemMapper;

	@Bean
	public ItemService itemService() {
		return new ItemServiceV1(itemRepository());
	}

	@Bean
	public ItemRepository itemRepository() {
		return new MybatisItemRepository(itemMapper);
	}
}
