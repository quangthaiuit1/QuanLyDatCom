package trong.lixco.com.bean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;
import org.omnifaces.cdi.ViewScoped;
import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;

import trong.lixco.com.account.servicepublics.Member;
import trong.lixco.com.bean.staticentity.Notification;
import trong.lixco.com.ejb.service.CategoryFoodService;
import trong.lixco.com.jpa.entity.CategoryFood;
import trong.lixco.com.util.Notify;
import trong.lixco.com.util.ResizeImage;

@Named
@ViewScoped
public class CaiDatDanhMucBean extends AbstractBean<CategoryFood> {

	private static final long serialVersionUID = 1L;
	private java.util.List<CategoryFood> categoryFoods;
	private List<CategoryFood> categoryFoodsFilter;
//	private java.util.List<CategoryFood> categoryFoodsRemove;
//	private CategoryFood categoryFoodSelected;
	private CategoryFood cFoodNew;
	private CategoryFood cFoodUpdate;

	private Notify notify;
	private Member member;

	@Inject
	private CategoryFoodService CATEGORY_FOOD_SERVICE;

	@Override
	protected void initItem() {
		cFoodNew = new CategoryFood();
		cFoodUpdate = new CategoryFood();
		notify = new Notify(FacesContext.getCurrentInstance());
		categoryFoods = new ArrayList<CategoryFood>();
//		categoryFoodsRemove = new ArrayList<>();
		try {
			categoryFoods = CATEGORY_FOOD_SERVICE.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		member = getAccount().getMember();

	}

//	public void addRowNew() {
//		CategoryFood categoryTemp = new CategoryFood();
//		categoryTemp.setCreatedUser(member.getName());
//		categoryFoods.add(categoryTemp);
//	}

//	public void saveOrUpdate() {
//		// remove list deleted
//		for (CategoryFood c : categoryFoodsRemove) {
//			CATEGORY_FOOD_SERVICE.delete(c);
//		}
//
//		// update
//		for (int i = 0; i < categoryFoods.size(); i++) {
//			// chua co duoi db
//			if (categoryFoods.get(i).getId() == null) {
//				if (!categoryFoods.get(i).getName().isEmpty() && categoryFoods.get(i).getName() != null) {
//					CategoryFood a = CATEGORY_FOOD_SERVICE.create(categoryFoods.get(i));
//					if (a != null) {
//						System.out.println("Thanh cong");
//					} else {
//						System.out.println("That bai");
//					}
//				}
//			} else {
//				CATEGORY_FOOD_SERVICE.update(categoryFoods.get(i));
//			}
//		}
//		categoryFoodsRemove = new ArrayList<>();
//		CommonService.successNotify();
//	}

	// UPLOAD IMAGE

	public void uploadAlbum(FileUploadEvent event) {
		notify = new Notify(FacesContext.getCurrentInstance());
		try (InputStream input = event.getFile().getInputstream()) {
			byte[] file = ResizeImage.toByteArray(input);
			cFoodNew.setImage(file);
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('dlavatar').hide();");
		} catch (Exception e) {
			e.printStackTrace();
			notify.error();
		}

	}

	// END UPLOAD IMAGE
	// UPload image update
	public void uploadAlbumUpdate(FileUploadEvent event) {
		notify = new Notify(FacesContext.getCurrentInstance());
		try (InputStream input = event.getFile().getInputstream()) {
			byte[] file = ResizeImage.toByteArray(input);
			cFoodUpdate.setImage(file);
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('dlavatar1').hide();");
		} catch (Exception e) {
			e.printStackTrace();
			notify.error();
		}

	}

	public void deleteRow(CategoryFood item) {
		for (CategoryFood food : categoryFoods) {
			if (food.getId() == item.getId()) {
				boolean delete = CATEGORY_FOOD_SERVICE.delete(item);
				if (delete) {
					categoryFoods = CATEGORY_FOOD_SERVICE.findAll();
					Notification.NOTI_SUCCESS("Xóa thành công");
				} else {
					Notification.NOTI_ERROR("Xóa không thành công");
				}
			}
		}
	}

	// NEW update category food
	public void updateItem() {
		try {
			// check co trung ten hay khong
			List<CategoryFood> checkExistName = CATEGORY_FOOD_SERVICE.findByName(cFoodUpdate.getName());
			if (checkExistName.isEmpty()) {
				CategoryFood cfUpdate = CATEGORY_FOOD_SERVICE.update(cFoodUpdate);
				if (cfUpdate != null) {
					Notification.NOTI_SUCCESS("Thành công");
					categoryFoods = CATEGORY_FOOD_SERVICE.findAll();
					cFoodUpdate = new CategoryFood();
					PrimeFaces current = PrimeFaces.current();
					current.executeScript("PF('widgetCapNhatMonAn').hide();");
				} else {
					Notification.NOTI_ERROR("Thất bại");
				}
			} else {
				categoryFoods = CATEGORY_FOOD_SERVICE.findAll();
				Notification.NOTI_ERROR("Tên món ăn đã tồn tại");
			}
		} catch (Exception e) {
		}
	}

	// NEW add new category food
	public void addNewItem() {
		if (cFoodNew.getName() != null && cFoodNew.getImage() != null) {
			// check co trung ten hay khong
			List<CategoryFood> checkExistName = CATEGORY_FOOD_SERVICE.findByName(cFoodNew.getName());
			if (checkExistName.isEmpty()) {
				CategoryFood cfNew = CATEGORY_FOOD_SERVICE.create(cFoodNew);
				if (cfNew != null) {
					Notification.NOTI_SUCCESS("Thành công");
					categoryFoods = CATEGORY_FOOD_SERVICE.findAll();
					cFoodNew = new CategoryFood();
					PrimeFaces current = PrimeFaces.current();
					current.executeScript("PF('widgetThemMonAn').hide();");
				} else {
					Notification.NOTI_ERROR("Không thành công");
				}
			} else {
				Notification.NOTI_ERROR("Tên món ăn đã tồn tại");
			}
		} else {
			Notification.NOTI_WARN("Vui lòng điền đầy đủ thông tin");
		}
	}

	@Override
	protected Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	public java.util.List<CategoryFood> getCategoryFoods() {
		return categoryFoods;
	}

	public void setCategoryFoods(java.util.List<CategoryFood> categoryFoods) {
		this.categoryFoods = categoryFoods;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<CategoryFood> getCategoryFoodsFilter() {
		return categoryFoodsFilter;
	}

	public void setCategoryFoodsFilter(List<CategoryFood> categoryFoodsFilter) {
		this.categoryFoodsFilter = categoryFoodsFilter;
	}

	public CategoryFood getcFoodNew() {
		return cFoodNew;
	}

	public void setcFoodNew(CategoryFood cFoodNew) {
		this.cFoodNew = cFoodNew;
	}

	public CategoryFood getcFoodUpdate() {
		return cFoodUpdate;
	}

	public void setcFoodUpdate(CategoryFood cFoodUpdate) {
		this.cFoodUpdate = cFoodUpdate;
	}
}
