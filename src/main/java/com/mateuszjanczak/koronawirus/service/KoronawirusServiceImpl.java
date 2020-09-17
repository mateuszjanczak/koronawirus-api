package com.mateuszjanczak.koronawirus.service;

import com.mateuszjanczak.koronawirus.exception.ReportNotFound;
import com.mateuszjanczak.koronawirus.model.Report;
import com.mateuszjanczak.koronawirus.webscraper.KoronawirusWebscraper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KoronawirusServiceImpl implements KoronawirusService {

    public final List<Report> list;

    public KoronawirusServiceImpl(KoronawirusWebscraper koronawirusWebscraper) {
        this.list = koronawirusWebscraper.loadList();
    }

    @Override
    public List<Report> getAll() {
        return list;
    }

    @Override
    public Report getById(int id) {
        return list.stream().filter(report -> report.getId() == id).findFirst().orElseThrow(() -> new ReportNotFound(id));
    }

    @Override
    public Report getByWojewodztwo(String wojewodztwo) {
        return list.stream().filter(report -> report.getWojewodztwo().equals(wojewodztwo)).findFirst().orElseThrow(() -> new ReportNotFound(wojewodztwo));
    }
}
