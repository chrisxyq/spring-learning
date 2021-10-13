import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chrisxu
 * @create 2021-10-07 22:00
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        if (source == null) {
            throw new RuntimeException("请传入数据");
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        Date date = null;
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换错误");
        }
        return date;
    }
}
