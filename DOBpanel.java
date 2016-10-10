package calendar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.qt.datapicker.DatePicker;

@SuppressWarnings("serial")
public class DOBpanel extends JPanel implements ActionListener {

	JTextField todayTF, ageYearTF, ageMonthTF, ageDaysTF;
	JLabel todayJL, ageJL, yearJL, monthJL, dayJL;
	JButton dobJB, check;
	DatePicker bd; // jar file imported for picking date
	// Date date;
	static int yearPicked, monthPicked, dayPicked;
	ObservingTextField dobTF = new ObservingTextField(); // since date picker
															// need observing
															// text fill

	public DOBpanel() {
		todayTF = new JTextField(10);
		dobTF.setColumns(10);
		ageYearTF = new JTextField(10);
		ageMonthTF = new JTextField(10);
		ageDaysTF = new JTextField(10);
		todayJL = new JLabel("TODAY");
		dobJB = new JButton("DATE OF BIRTH");
		ageJL = new JLabel("AGE");
		yearJL = new JLabel("YEAR");
		monthJL = new JLabel("MONTH");
		dayJL = new JLabel("DAYS");
		check = new JButton("    CHECK AGE    ");
		JPanel panel = new JPanel();
		panel.add(todayJL);
		panel.add(todayTF);
		panel.add(dobJB);
		panel.add(dobTF);
		panel.add(check);
		panel.add(ageYearTF);
		panel.add(yearJL);
		panel.add(ageMonthTF);
		panel.add(monthJL);
		panel.add(ageDaysTF);
		panel.add(dayJL);

		final Locale locale = getLocale(null);
		DatePicker dp = new DatePicker((Observer) dobTF, locale);
		dobJB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date selectedDate = dp.parseDate(dobTF.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(dobTF);
			}
		});

		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("check button clicked");
				Date selectedDate = dp.parseDate(dobTF.getText());
				long selectedDate2 = selectedDate.getTime();
				Date presentDate = DOBM.getTime();
				long presentDate2 = presentDate.getTime();
				long age;
				age = presentDate2 - selectedDate2;
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(age);
				int ageYear = c.get(Calendar.YEAR) - 1970;
				int ageMonth = c.get(Calendar.MONTH);
				int ageDays = c.get(Calendar.DATE);
				ageYearTF.setText(Integer.toString(ageYear));
				ageMonthTF.setText(Integer.toString(ageMonth));
				ageDaysTF.setText(Integer.toString(ageDays));
			}
		});

		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);
		todayTF.setText(DOBM.presentDate());
	}

	private static Locale getLocale(String loc) {
		if (loc != null && loc.length() > 0)
			return new Locale(loc);
		else
			return Locale.US;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}

@SuppressWarnings("serial")
class ObservingTextField extends JTextField implements Observer {
	public void update(Observable o, Object arg) {
		Calendar calendar = (Calendar) arg;
		DatePicker dp = (DatePicker) o;
		System.out.println("picked=" + dp.formatDate(calendar));
		setText(dp.formatDate(calendar));
	}
}
