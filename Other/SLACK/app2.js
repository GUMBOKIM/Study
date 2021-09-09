import pug from 'pug';
import path from 'path';
import axios from 'axios';
import pkg from 'date-fns-tz';

const __dirname = path.resolve();

const slackUrl =
  'https://hooks.slack.com/services/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';
const sendTarget = '@' + encodeURIComponent('jino');

const sendSlack = function async(sendTarget, sendMessage) {
  const data = {
    channel: sendTarget,
    text: sendMessage,
  };
  return axios.post(slackUrl, data);
};

// 객체 추가 필요
export const sendSlackMessage_NewStudentCancellation = async (sendTarget) => {
  try {
    const compiledFunction = pug.compileFile(
      path.join(__dirname, `newStudentCancellation.pug`)
    );
    const sendMessage = await compiledFunction({
      classTime: '클래스타임',
      course: '코스',
      className: '클래스',
    });
    sendSlack(sendTarget, sendMessage);
  } catch (e) {
    console.error(e);
  }
};

export const sendSlackMessage_ClassReminder = async (sendTarget, timeZone) => {
  try {
    if (timeZone) {
      const date = pkg.utcToZonedTime(new Date(), timeZone);

      const compiledFunction = pug.compileFile(
        path.join(__dirname, `classReminder.pug`)
      );
      const sendMessage = await compiledFunction({
        todayDate: date,
      });

      sendSlack(sendTarget, sendMessage);
    }
  } catch (e) {
    console.error(e);
  }
};

sendSlackMessage_ClassReminder(sendTarget, 'Asia/Seoul');
sendSlackMessage_NewStudentCancellation(sendTarget);
