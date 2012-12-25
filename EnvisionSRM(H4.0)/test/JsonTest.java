import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.JsonUtil;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.model.CategoryType;

/**
 * 
 */

/**
 * @author Janlu
 * 
 */
public class JsonTest {

	@Test
	public void testJson() {
		MaterialCategory materialCategory = new MaterialCategory();
		materialCategory.setId(1);
		materialCategory.setCreateDate(new Date());
		materialCategory.setCategoryType(CategoryType.MaterialCategory.toText());
		materialCategory.setIslock(false);
		materialCategory.setName("a");
		System.out.println(JsonUtil.parseObject(materialCategory));
	}

	@Test
	public void testDate() {
		String dateString = "2012-11-19";
		try {
			System.out.println(DateUtil.formatDate(DateUtil.formateAddOneDate(dateString)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
