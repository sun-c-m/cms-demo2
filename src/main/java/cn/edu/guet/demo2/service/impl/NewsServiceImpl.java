package cn.edu.guet.demo2.service.impl;

import cn.edu.guet.demo2.dto.NewsCreateDTO;
import cn.edu.guet.demo2.entity.News;
import cn.edu.guet.demo2.mapper.NewsMapper;
import cn.edu.guet.demo2.service.NewsService;
import cn.edu.guet.demo2.vo.NewsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import cn.edu.guet.demo2.util.PageRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Service
public class NewsServiceImpl implements NewsService {
    private static final String PENDING_REVIEW = "PENDING_REVIEW";
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public NewsVO getNewsDetail(Long id) {
        News news = newsMapper.selectById(id);
        if (news == null) {
            throw new IllegalArgumentException("新闻不存在");
        }
        return toVO(news);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public NewsVO createNews(NewsCreateDTO newsCreateDTO) {
        validateNews(newsCreateDTO);

        News news = new News();
        news.setTitle(newsCreateDTO.getTitle());
        news.setCategory(newsCreateDTO.getCategory());
        news.setSupplier(newsCreateDTO.getSupplier());
        news.setReviewer(newsCreateDTO.getReviewer());
        news.setContent(newsCreateDTO.getContent());
        news.setStatus(PENDING_REVIEW);

        newsMapper.insert(news);

        return getNewsDetail(news.getId());
    }
    private void validateNews(NewsCreateDTO newsCreateDTO) {
        if (newsCreateDTO.getTitle() == null||
        !StringUtils.hasText(newsCreateDTO.getTitle())) {
            throw new IllegalArgumentException("新闻标题不能为空");
        }
        if(!StringUtils.hasText(newsCreateDTO.getCategory())){
            throw new IllegalArgumentException("栏目分类不能为空");
        }
        if(!StringUtils.hasText(newsCreateDTO.getContent())){
            throw new IllegalArgumentException("正文内容不能为空");
        }
    }
    private NewsVO toVO(News news) {
        NewsVO newsVO = new NewsVO();
        BeanUtils.copyProperties(news, newsVO);
        return newsVO;
    }

    public IPage<NewsVO> getNewsPage(PageRequest pageRequest) {
        Page<News> page = new Page<>(pageRequest.getCurrentPage(), pageRequest.getPageSize());
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();

        String keyword = pageRequest.getParamValue("keyword");
        if (StringUtils.hasText(keyword)) {
            queryWrapper.and(wrapper -> wrapper
                    .like("title", keyword)
                    .or()
                    .like("supplier", keyword)
                    .or()
                    .like("reviewer", keyword));
        }

        String category = pageRequest.getParamValue("category");
        if (StringUtils.hasText(category)) {
            queryWrapper.eq("category", category);
        }

        String status = pageRequest.getParamValue("status");
        if (StringUtils.hasText(status)) {
            queryWrapper.eq("status", status);
        }

        queryWrapper.orderByDesc("update_time", "id");

        return newsMapper.selectPage(page, queryWrapper).convert(this::toVO);
    }
}
