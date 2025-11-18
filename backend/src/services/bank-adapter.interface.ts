export interface BankAdapter {
  createAuthSession(userId: string): Promise<{ authUrl: string; sessionId: string }>;
  handleCallback(sessionId: string, params: any): Promise<void>;
  fetchAccounts(connectionRecord: any): Promise<any[]>;
  fetchTransactions(connectionRecord: any, accountId: string, from?: string, to?: string): Promise<any[]>;
  refreshToken(connectionRecord: any): Promise<void>;
}
