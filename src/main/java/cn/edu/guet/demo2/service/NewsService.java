package cn.edu.guet.demo2.service;

import cn.edu.guet.demo2.dto.NewsCreateDTO;
import cn.edu.guet.demo2.util.PageRequest;
import cn.edu.guet.demo2.vo.NewsVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;

public interface NewsService {
    NewsVO getNewsDetail(Long id);

    @Transactional(rollbackFor = Exception.class)
    NewsVO createNews(NewsCreateDTO newsCreateDTO);

    IPage<NewsVO> getNewsPage(PageRequest pageRequest);
}
