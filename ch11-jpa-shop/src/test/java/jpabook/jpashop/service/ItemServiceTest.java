package jpabook.jpashop.service;

import static org.junit.Assert.assertEquals;
import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.repository.ItemRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class ItemServiceTest {
	@Autowired ItemService itemService;
	@Autowired ItemRepository itemRepository;
	
	@Test
	public void 아이템등록() throws Exception {
		
		//Given
		Album album = new Album();
		album.setName("Book1");
		album.setPrice(10000);
		album.setStockQuantity(100);
		album.setArtist("sangmin");
		album.setEtc("Wonderful");
		
		//When
		itemService.saveItem(album);
		
        //Then
        //assertEquals(album, itemRepository.findOne(album.getId()));
        assertEquals("Book1", itemRepository.findOne(album.getId()).getName());
	
	}
	
	
}
