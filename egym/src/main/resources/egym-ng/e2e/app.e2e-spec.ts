import { EgymNgPage } from './app.po';

describe('egym-ng App', function() {
  let page: EgymNgPage;

  beforeEach(() => {
    page = new EgymNgPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
