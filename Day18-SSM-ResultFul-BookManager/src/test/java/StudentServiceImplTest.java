import com.WPF.domain.ClassRoom;
import com.WPF.domain.Student;
import com.WPF.service.ClassRoomService;
import com.WPF.service.StudentService;
import com.WPF.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class StudentServiceImplTest {

	@Resource
	private StudentService studentService;
	@Resource
	private ClassRoomService classRoomService;

	@Test
	public void getAllStudent() {
		List<Student> studentClassRooms = studentService.getAllStudent();
		System.out.println(studentClassRooms);

	}

	@Test
	public void getAllClassRoom() {
		List<ClassRoom> classRooms = classRoomService.getAllClassRoom();
		System.out.println(classRooms.get(0).getClass_name());
		System.out.println(classRooms.get(0).getStudents().get(0));
//		System.out.println(classRooms);
	}
}